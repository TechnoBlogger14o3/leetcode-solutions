#!/usr/bin/env python3
import os, re, json, subprocess, textwrap
from pathlib import Path
from datetime import datetime, timezone
import requests
from dateutil import tz

# -----------------------
# Config
# -----------------------
LEETCODE_GRAPHQL = "https://leetcode.com/graphql"
HEADERS = {"Content-Type": "application/json"}
SESSION_COOKIE = os.getenv("LEETCODE_SESSION")
MODEL = os.getenv("LLM_MODEL", "gpt-4o-mini")

ROOT = Path(__file__).resolve().parents[1]
README = ROOT / "README.md"

# Difficulty folders
DIFF_MAP = {"Easy": "Easy", "Medium": "Medium", "Hard": "Hard"}

# -----------------------
# Helpers
# -----------------------
def graphql(query: str, variables=None):
    cookies = {"LEETCODE_SESSION": SESSION_COOKIE} if SESSION_COOKIE else None
    r = requests.post(LEETCODE_GRAPHQL, headers=HEADERS, cookies=cookies, json={"query": query, "variables": variables or {}}, timeout=30)
    r.raise_for_status()
    data = r.json()
    if "errors" in data:
        raise RuntimeError(data["errors"])
    return data["data"]

def get_daily():
    q = """
    query questionOfToday {
      activeDailyCodingChallengeQuestion {
        date
        link
        question {
          questionFrontendId
          title
          titleSlug
          difficulty
          content
          exampleTestcases
        }
      }
    }
    """
    node = graphql(q)["activeDailyCodingChallengeQuestion"]
    return {
        "date": node["date"],
        "id": node["question"]["questionFrontendId"],
        "title": node["question"]["title"],
        "slug": node["question"]["titleSlug"],
        "difficulty": node["question"]["difficulty"],
        "content": node["question"]["content"],
        "examples": node["question"]["exampleTestcases"],
        "link": "https://leetcode.com" + node["link"],
    }

def ist_today():
    ist = tz.gettz("Asia/Kolkata")
    return datetime.now(timezone.utc).astimezone(ist).date()

def safe_title(s: str) -> str:
    return re.sub(r'[^A-Za-z0-9]+', '-', s).strip('-')

def call_llm(prompt: str, lang: str) -> str:
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
    return resp.choices[0].message.content.strip().removeprefix("```").removesuffix("```").strip()

def build_prompt(meta, lang: str):
    return textwrap.dedent(f"""
    Solve the following LeetCode problem in {lang}:

    Title: {meta['title']}
    Difficulty: {meta['difficulty']}
    Problem ID: {meta['id']}
    Link: {meta['link']}

    Problem statement (HTML removed):
    {re.sub(r"<[^>]+>", " ", meta['content'])}

    Example test cases:
    {meta['examples']}

    Requirements:
    - Write a correct, optimized {lang} solution for LeetCode submission.
    - Use standard LeetCode function/class signatures.
    - Do NOT include explanations in output, only code.
    """)

def update_readme(entry: str):
    if not README.exists():
        README.write_text("# LeetCode Daily Solutions\n\n", encoding="utf-8")
    current = README.read_text(encoding="utf-8")
    if entry not in current:
        README.write_text(current + entry + "\n", encoding="utf-8")

# -----------------------
# Main
# -----------------------
def main():
    daily = get_daily()
    today = ist_today().isoformat()
    title_clean = safe_title(daily["title"])
    diff_folder = DIFF_MAP[daily["difficulty"]]
    problem_dir = ROOT / diff_folder / f"{today}-{daily['id']}-{title_clean}"

    if problem_dir.exists():
        print("Already solved today.")
        return
    problem_dir.mkdir(parents=True, exist_ok=True)

    # Generate solutions in multiple languages
    langs = {"python": "solution.py", "java": "solution.java", "javascript": "solution.js"}
    for lang, fname in langs.items():
        code = call_llm(build_prompt(daily, lang), lang)
        (problem_dir / fname).write_text(code, encoding="utf-8")

    # Explanation file
    explanation = f"""# {daily['title']} ({daily['difficulty']})

**Problem ID:** {daily['id']}  
**Date:** {today}  
**Link:** {daily['link']}

## Approach

- Optimized solution implemented in Python, Java, and JavaScript.

"""
    (problem_dir / "explanation.md").write_text(explanation, encoding="utf-8")

    # Update README index
    entry = f"- {today} — [{daily['title']}]({daily['link']}) ({daily['difficulty']}) → `{diff_folder}/{problem_dir.name}`"
    update_readme(entry)

    print("✅ Added:", problem_dir)

if __name__ == "__main__":
    main()
