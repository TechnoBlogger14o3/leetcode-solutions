#!/usr/bin/env python3
"""
Solve problems from Striver's SDE Sheet
Fetches problem details from LeetCode and generates solutions
Commits after each problem
"""
import os
import re
import json
import subprocess
import textwrap
from pathlib import Path
from datetime import datetime
import requests
import time

# Config
LEETCODE_GRAPHQL = "https://leetcode.com/graphql"
HEADERS = {"Content-Type": "application/json"}
SESSION_COOKIE = os.getenv("LEETCODE_SESSION")
MODEL = os.getenv("LLM_MODEL", "gpt-4o-mini")

ROOT = Path(__file__).resolve().parents[1]
PROBLEMS_JSON = ROOT / "striver_sde_sheet_problems.json"
STRIVER_DIR = ROOT / "striver-sde-sheet"
PROGRESS_FILE = ROOT / ".striver_progress.json"

def graphql(query: str, variables=None):
    """Make GraphQL request to LeetCode"""
    cookies = {"LEETCODE_SESSION": SESSION_COOKIE} if SESSION_COOKIE else None
    try:
        r = requests.post(
            LEETCODE_GRAPHQL,
            headers=HEADERS,
            cookies=cookies,
            json={"query": query, "variables": variables or {}},
            timeout=30,
        )
        r.raise_for_status()
        data = r.json()
        if "errors" in data:
            return None
        return data["data"]
    except Exception as e:
        print(f"Error in GraphQL request: {e}")
        return None

def search_problem_by_title(title: str):
    """Search for a problem on LeetCode by title"""
    # Clean title for search - use key words
    clean_title = re.sub(r'[^a-zA-Z0-9\s]', ' ', title).strip()
    # Extract key words (remove common words)
    words = [w for w in clean_title.split() if len(w) > 2 and w.lower() not in ['the', 'and', 'for', 'with', 'without', 'using']]
    if not words:
        return None
    
    search_key = ' '.join(words[:5])  # Use first 5 meaningful words
    
    query = """
    query problemsetQuestionList($categorySlug: String, $limit: Int, $skip: Int, $filters: QuestionListFilterInput) {
      problemsetQuestionList(
        categorySlug: $categorySlug
        limit: $limit
        skip: $skip
        filters: $filters
      ) {
        total
        questions {
          questionFrontendId
          title
          titleSlug
          difficulty
        }
      }
    }
    """
    
    # Try exact match first
    variables = {
        "categorySlug": "",
        "limit": 50,
        "skip": 0,
        "filters": {"searchKeywords": search_key}
    }
    
    try:
        data = graphql(query, variables)
        if not data or "problemsetQuestionList" not in data:
            return None
        
        questions = data["problemsetQuestionList"].get("questions", [])
        
        # Find best match
        title_lower = clean_title.lower()
        for q in questions:
            q_title_lower = q["title"].lower()
            # Check if titles match significantly
            if title_lower in q_title_lower or q_title_lower in title_lower:
                return q
            # Check word overlap
            q_words = set(q_title_lower.split())
            title_words = set(title_lower.split())
            if len(q_words & title_words) >= 2:  # At least 2 words match
                return q
        
        # Return first result if any
        return questions[0] if questions else None
    except Exception as e:
        print(f"Search error: {e}")
        return None

def get_problem_by_slug(slug: str):
    """Get full problem details by slug"""
    query = """
    query questionData($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        questionId
        questionFrontendId
        title
        titleSlug
        difficulty
        content
        exampleTestcases
        codeSnippets {
          lang
          langSlug
          code
        }
      }
    }
    """
    data = graphql(query, {"titleSlug": slug})
    if not data or "question" not in data:
        return None
    return data["question"]

def safe_title(s: str) -> str:
    """Convert title to safe filename"""
    return re.sub(r"[^A-Za-z0-9]+", "-", s).strip("-")

def call_llm(prompt: str, lang: str) -> str:
    """Call OpenAI API to generate solution"""
    from openai import OpenAI
    client = OpenAI(api_key=os.getenv("OPENAI_API_KEY"))
    resp = client.chat.completions.create(
        model=MODEL,
        messages=[
            {"role": "system", "content": f"You are a senior competitive programmer. Output only valid {lang} code, no explanations."},
            {"role": "user", "content": prompt},
        ],
        temperature=0.2,
    )
    content = resp.choices[0].message.content.strip()
    # Remove triple backticks and language hints
    content = re.sub(r"^```[a-zA-Z]*\n?", "", content)
    content = re.sub(r"```$", "", content).strip()
    return content

def build_prompt(meta, lang: str):
    """Build prompt for LLM"""
    return textwrap.dedent(f"""
    Solve the following LeetCode problem in {lang}:

    Title: {meta['title']}
    Difficulty: {meta['difficulty']}
    Problem ID: {meta['id']}
    Link: https://leetcode.com/problems/{meta['slug']}

    Problem statement (HTML removed):
    {re.sub(r'<[^>]+>', ' ', meta['content'])}

    Example test cases:
    {meta['examples']}

    Requirements:
    - Write a correct, optimized {lang} solution for LeetCode submission.
    - Use standard LeetCode function/class signatures.
    - Do NOT include explanations in output, only code.
    """)

def load_progress():
    """Load progress tracking"""
    if PROGRESS_FILE.exists():
        with open(PROGRESS_FILE, 'r') as f:
            return json.load(f)
    return {"solved": [], "skipped": [], "last_number": 0}

def save_progress(progress):
    """Save progress tracking"""
    with open(PROGRESS_FILE, 'w') as f:
        json.dump(progress, f, indent=2)

def git_commit(problem_num, title):
    """Commit and push the solution"""
    try:
        subprocess.run(
            ["git", "add", "-A"],
            cwd=ROOT,
            check=True,
            capture_output=True
        )
        commit_msg = f"feat: solve Striver SDE Sheet problem {problem_num} - {title}"
        subprocess.run(
            ["git", "commit", "-m", commit_msg],
            cwd=ROOT,
            check=True,
            capture_output=True
        )
        print(f"✅ Committed: {commit_msg}")
        
        # Push to remote
        try:
            subprocess.run(
                ["git", "push"],
                cwd=ROOT,
                check=True,
                capture_output=True
            )
            print(f"✅ Pushed to remote")
        except subprocess.CalledProcessError:
            # Try setting upstream if not set
            try:
                subprocess.run(
                    ["git", "push", "--set-upstream", "origin", "strivers_list"],
                    cwd=ROOT,
                    check=True,
                    capture_output=True
                )
                print(f"✅ Pushed to remote (set upstream)")
            except subprocess.CalledProcessError as push_err:
                print(f"⚠️  Git push failed: {push_err}")
        return True
    except subprocess.CalledProcessError as e:
        print(f"⚠️  Git commit/push failed: {e}")
        return False

def solve_problem(problem, progress):
    """Solve a single problem"""
    problem_num = problem["number"]
    title = problem.get("title", "Unknown")
    slug = problem.get("title_slug")
    
    # Skip if already solved
    if problem_num in progress["solved"]:
        print(f"⏭️  Problem {problem_num} already solved, skipping...")
        return True
    
    print(f"\n{'='*60}")
    print(f"Solving problem {problem_num}: {title}")
    print(f"{'='*60}")
    
    # Try to get problem details
    problem_data = None
    
    # Only use slugs that are complete (more than 5 chars and don't end with hyphen)
    if slug and len(slug) > 5 and not slug.endswith('-'):
        print(f"Fetching problem by slug: {slug}")
        problem_data = get_problem_by_slug(slug)
        if problem_data:
            print(f"✅ Found: {problem_data['title']}")
    
    # Skip search for now due to API issues - focus on problems with slugs
    # if not problem_data and title and title != "Unknown":
    #     print(f"Searching LeetCode for: {title}")
    #     search_result = search_problem_by_title(title)
    #     if search_result:
    #         print(f"Found: {search_result['title']} ({search_result['titleSlug']})")
    #         problem_data = get_problem_by_slug(search_result['titleSlug'])
    
    if not problem_data:
        print(f"❌ Could not find problem on LeetCode (no valid slug). Skipping...")
        progress["skipped"].append(problem_num)
        save_progress(progress)
        return False
    
    # Create problem directory
    safe_name = safe_title(problem_data['title'])
    problem_dir = STRIVER_DIR / f"{problem_num:03d}-{problem_data['questionFrontendId']}-{safe_name}"
    
    if problem_dir.exists():
        print(f"⏭️  Directory already exists, skipping...")
        progress["solved"].append(problem_num)
        save_progress(progress)
        return True
    
    problem_dir.mkdir(parents=True, exist_ok=True)
    
    # Prepare problem metadata
    meta = {
        "id": problem_data['questionFrontendId'],
        "title": problem_data['title'],
        "slug": problem_data['titleSlug'],
        "difficulty": problem_data['difficulty'],
        "content": problem_data.get('content', ''),
        "examples": problem_data.get('exampleTestcases', '')
    }
    
    # Generate solutions in multiple languages
    langs = {"python": "solution.py", "java": "solution.java", "javascript": "solution.js"}
    for lang, fname in langs.items():
        try:
            print(f"Generating {lang} solution...")
            code = call_llm(build_prompt(meta, lang), lang)
            (problem_dir / fname).write_text(code, encoding="utf-8")
            print(f"✅ Generated {fname}")
        except Exception as e:
            print(f"❌ Error generating {lang} solution: {e}")
    
    # Create README
    readme_content = f"""# {meta['title']} ({meta['difficulty']})

**Problem ID:** {meta['id']}  
**Problem Number:** {problem_num}  
**Link:** https://leetcode.com/problems/{meta['slug']}

## Problem Statement

{re.sub(r'<[^>]+>', '', meta['content'])[:500]}...

## Solutions

- Python: `solution.py`
- Java: `solution.java`
- JavaScript: `solution.js`
"""
    (problem_dir / "README.md").write_text(readme_content, encoding="utf-8")
    
    # Mark as solved and commit
    progress["solved"].append(problem_num)
    progress["last_number"] = problem_num
    save_progress(progress)
    
    # Commit
    git_commit(problem_num, meta['title'])
    
    print(f"✅ Problem {problem_num} solved and committed!")
    return True

def main():
    """Main function"""
    # Load problems
    if not PROBLEMS_JSON.exists():
        print(f"❌ Problems JSON not found: {PROBLEMS_JSON}")
        print("Run extract_dsa_sheet_problems.py first")
        return
    
    with open(PROBLEMS_JSON, 'r') as f:
        problems = json.load(f)
    
    # Load progress
    progress = load_progress()
    
    print(f"Total problems: {len(problems)}")
    print(f"Already solved: {len(progress['solved'])}")
    print(f"Target: 100 problems today")
    
    # Filter unsolved problems
    unsolved = [p for p in problems if p["number"] not in progress["solved"]]
    print(f"Remaining: {len(unsolved)}")
    
    # Prioritize problems with slugs
    unsolved_with_slugs = [p for p in unsolved if p.get("title_slug") and len(p.get("title_slug", "")) > 5 and not p.get("title_slug", "").endswith("-")]
    unsolved_without_slugs = [p for p in unsolved if p not in unsolved_with_slugs]
    
    print(f"Problems with slugs: {len(unsolved_with_slugs)}")
    print(f"Problems without slugs: {len(unsolved_without_slugs)}")
    
    # Solve problems - prioritize those with slugs
    solved_count = 0
    target = 100
    
    # First solve problems with slugs
    for problem in unsolved_with_slugs[:target]:
        if solve_problem(problem, progress):
            solved_count += 1
            print(f"\nProgress: {solved_count}/{target} problems solved")
        
        # Small delay to avoid rate limiting
        time.sleep(2)
        
        if solved_count >= target:
            break
    
    # If we haven't reached target, try problems without slugs (but they'll likely fail)
    if solved_count < target:
        print(f"\n⚠️  Only {solved_count} problems solved with slugs. Trying problems without slugs...")
        for problem in unsolved_without_slugs[:target - solved_count]:
            if solve_problem(problem, progress):
                solved_count += 1
                print(f"\nProgress: {solved_count}/{target} problems solved")
            
            time.sleep(2)
            
            if solved_count >= target:
                break
    
    print(f"\n{'='*60}")
    print(f"✅ Completed {solved_count} problems!")
    print(f"{'='*60}")

if __name__ == "__main__":
    main()

