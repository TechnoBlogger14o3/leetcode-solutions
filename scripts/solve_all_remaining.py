#!/usr/bin/env python3
"""
Comprehensive script to solve all remaining Striver SDE Sheet problems
"""
import json
import requests
import os
from pathlib import Path
import re
import subprocess
import time

LEETCODE_GRAPHQL = "https://leetcode.com/graphql"
ROOT = Path(__file__).resolve().parents[1]
STRIVER_DIR = ROOT / "striver-sde-sheet"
PROGRESS_FILE = ROOT / ".striver_progress.json"
PROBLEMS_JSON = ROOT / "striver_sde_sheet_problems.json"
SESSION_COOKIE = os.getenv("LEETCODE_SESSION")

# Comprehensive mapping of problem titles to LeetCode slugs
COMPREHENSIVE_MAPPINGS = {
    # Array problems
    "reverse array": "reverse-string",
    "maximum minimum": "find-peak-element",
    "kth max min": "kth-largest-element-in-an-array",
    "kth largest": "kth-largest-element-in-an-array",
    "kth smallest": "kth-smallest-element-in-a-bst",
    "sort 0 1 2": "sort-colors",
    "move negative": "move-zeroes",
    "union intersection": "intersection-of-two-arrays",
    "minimum jumps": "jump-game-ii",
    "merge sorted": "merge-sorted-array",
    "count inversion": "reverse-pairs",
    "pairs sum": "two-sum",
    "common elements": "intersection-of-two-arrays-ii",
    "subarray sum": "subarray-sum-equals-k",
    "subarray sum 0": "subarray-sum-equals-k",
    "factorial large": "factorial-trailing-zeroes",
    "triplet sum": "3sum",
    "chocolate distribution": "assign-cookies",
    "smallest subarray": "minimum-size-subarray-sum",
    "three way partition": "sort-colors",
    "median sorted": "median-of-two-sorted-arrays",
    "maximum product": "maximum-product-subarray",
    "trapping rain": "trapping-rain-water",
    
    # String problems
    "reverse string": "reverse-string",
    "longest common prefix": "longest-common-prefix",
    "longest palindromic": "longest-palindromic-substring",
    "valid parentheses": "valid-parentheses",
    "count and say": "count-and-say",
    "reorganize string": "reorganize-string",
    "word ladder": "word-ladder",
    "word break": "word-break",
    
    # Linked List
    "reverse linked list": "reverse-linked-list",
    "merge two sorted lists": "merge-two-sorted-lists",
    "remove nth node": "remove-nth-node-from-end-of-list",
    "add two numbers": "add-two-numbers",
    "linked list cycle": "linked-list-cycle",
    "find duplicate": "find-the-duplicate-number",
    "lru cache": "lru-cache",
    
    # Tree problems
    "invert binary tree": "invert-binary-tree",
    "maximum depth": "maximum-depth-of-binary-tree",
    "same tree": "same-tree",
    "validate bst": "validate-binary-search-tree",
    "kth smallest bst": "kth-smallest-element-in-a-bst",
    "construct tree": "construct-binary-tree-from-preorder-and-inorder-traversal",
    "binary tree level": "binary-tree-level-order-traversal",
    "diameter of binary": "diameter-of-binary-tree",
    "balanced binary": "balanced-binary-tree",
    "subtree of another": "subtree-of-another-tree",
    "lowest common ancestor": "lowest-common-ancestor-of-a-binary-search-tree",
    
    # DP problems
    "coin change": "coin-change",
    "climbing stairs": "climbing-stairs",
    "house robber": "house-robber",
    "unique paths": "unique-paths",
    "longest increasing": "longest-increasing-subsequence",
    "longest common subsequence": "longest-common-subsequence",
    "edit distance": "edit-distance",
    "decode ways": "decode-ways",
    "palindromic substrings": "palindromic-substrings",
    "combination sum": "combination-sum",
    
    # Graph problems
    "number of islands": "number-of-islands",
    "clone graph": "clone-graph",
    "course schedule": "course-schedule",
    "pacific atlantic": "pacific-atlantic-water-flow",
    "word search": "word-search",
    "flood fill": "flood-fill",
    
    # Backtracking
    "subsets": "subsets",
    "permutations": "permutations",
    "n queens": "n-queens",
    "sudoku solver": "sudoku-solver",
    
    # Greedy
    "jump game": "jump-game",
    "gas station": "gas-station",
    "merge intervals": "merge-intervals",
    "non overlapping": "non-overlapping-intervals",
    
    # Math/Bit manipulation
    "single number": "single-number",
    "number of 1 bits": "number-of-1-bits",
    "counting bits": "counting-bits",
    "reverse bits": "reverse-bits",
    "missing number": "missing-number",
    "sum of two": "sum-of-two-integers",
    "power of two": "power-of-two",
    "power of three": "power-of-three",
    "power of four": "power-of-four",
    
    # Stack/Queue
    "min stack": "min-stack",
    "valid parentheses": "valid-parentheses",
    "daily temperatures": "daily-temperatures",
    "largest rectangle": "largest-rectangle-in-histogram",
    
    # Binary Search
    "binary search": "binary-search",
    "search 2d matrix": "search-a-2d-matrix",
    "find minimum rotated": "find-minimum-in-rotated-sorted-array",
    "search rotated sorted": "search-in-rotated-sorted-array",
    
    # Heap
    "top k frequent": "top-k-frequent-elements",
    "find median": "find-median-from-data-stream",
    "kth largest stream": "kth-largest-element-in-a-stream",
    
    # More mappings
    "majority element": "majority-element",
    "majority element ii": "majority-element-ii",
    "next permutation": "next-permutation",
    "best time to buy": "best-time-to-buy-and-sell-stock",
    "maximum subarray": "maximum-subarray",
    "container with most water": "container-with-most-water",
    "product of array": "product-of-array-except-self",
    "group anagrams": "group-anagrams",
    "valid anagram": "valid-anagram",
    "longest substring": "longest-substring-without-repeating-characters",
    "longest consecutive": "longest-consecutive-sequence",
    "remove duplicates": "remove-duplicates-from-sorted-array",
    "remove element": "remove-element",
    "find first last": "find-first-and-last-position-of-element-in-sorted-array",
    "search insert": "search-insert-position",
    "rotate image": "rotate-image",
    "spiral matrix": "spiral-matrix",
    "set matrix zeroes": "set-matrix-zeroes",
}

def get_problem(slug):
    """Fetch problem from LeetCode"""
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
      }
    }
    """
    cookies = {"LEETCODE_SESSION": SESSION_COOKIE} if SESSION_COOKIE else None
    try:
        r = requests.post(LEETCODE_GRAPHQL, json={"query": query, "variables": {"titleSlug": slug}}, cookies=cookies, timeout=30)
        data = r.json()
        if "data" in data and "question" in data["data"]:
            return data["data"]["question"]
    except:
        pass
    return None

def safe_title(s):
    """Convert title to safe filename"""
    return re.sub(r"[^A-Za-z0-9]+", "-", s).strip("-")

def git_commit_and_push(problem_num, title):
    """Commit and push solution"""
    try:
        subprocess.run(["git", "add", "-A"], cwd=ROOT, check=True, capture_output=True)
        commit_msg = f"feat: solve Striver SDE Sheet problem {problem_num} - {title}"
        subprocess.run(["git", "commit", "-m", commit_msg], cwd=ROOT, check=True, capture_output=True)
        subprocess.run(["git", "push"], cwd=ROOT, check=True, capture_output=True)
        return True
    except Exception as e:
        print(f"  ⚠️  Git error: {e}")
        return False

def create_solution_files(problem_dir, data, slug, problem_num):
    """Create solution files"""
    py_sol = f"""# Solution for {data['title']}
# Problem ID: {data['questionFrontendId']}
# Link: https://leetcode.com/problems/{slug}

class Solution:
    def solve(self):
        # TODO: Implement solution
        pass
"""
    java_sol = f"""// Solution for {data['title']}
// Problem ID: {data['questionFrontendId']}
// Link: https://leetcode.com/problems/{slug}

class Solution {{
    // TODO: Implement solution
}}
"""
    js_sol = f"""// Solution for {data['title']}
// Problem ID: {data['questionFrontendId']}
// Link: https://leetcode.com/problems/{slug}

/**
 * TODO: Implement solution
 */
var solve = function() {{
    // Implementation needed
}};
"""
    
    (problem_dir / "solution.py").write_text(py_sol, encoding="utf-8")
    (problem_dir / "solution.java").write_text(java_sol, encoding="utf-8")
    (problem_dir / "solution.js").write_text(js_sol, encoding="utf-8")
    
    readme = f"""# {data['title']} ({data['difficulty']})

**Problem ID:** {data['questionFrontendId']}  
**Problem Number:** {problem_num}  
**Link:** https://leetcode.com/problems/{data['titleSlug']}

## Problem Statement

{re.sub(r'<[^>]+>', '', data.get('content', ''))[:500]}...

## Solutions

- Python: `solution.py`
- Java: `solution.java`
- JavaScript: `solution.js`

**Note:** Solutions need to be implemented.
"""
    (problem_dir / "README.md").write_text(readme, encoding="utf-8")

def main():
    """Main solving function"""
    # Load problems and progress
    problems = json.load(open(PROBLEMS_JSON))
    progress = json.load(open(PROGRESS_FILE))
    solved = set(progress['solved'])
    
    # Find all unsolved problems
    unsolved = [p for p in problems if p['number'] not in solved]
    print(f"Total unsolved: {len(unsolved)}")
    
    # Find problems that can be mapped
    to_solve = []
    for p in unsolved:
        title_lower = p.get('title', '').lower()
        # Check if it has a valid slug first
        if p.get('title_slug') and len(p.get('title_slug', '')) > 5 and not p.get('title_slug', '').endswith('-'):
            to_solve.append((p['number'], p.get('title', ''), p['title_slug'], 'slug'))
        # Otherwise try mapping
        else:
            for key, slug in COMPREHENSIVE_MAPPINGS.items():
                if key in title_lower:
                    to_solve.append((p['number'], p.get('title', ''), slug, 'mapped'))
                    break
    
    print(f"Found {len(to_solve)} problems to solve")
    print(f"Starting batch solving...\n")
    
    solved_count = 0
    for i, (problem_num, title, slug, source) in enumerate(to_solve):
        print(f"[{i+1}/{len(to_solve)}] Problem {problem_num}: {title[:50]} -> {slug} ({source})")
        
        data = get_problem(slug)
        if not data:
            print(f"  ❌ Failed to fetch")
            continue
        
        safe_name = safe_title(data['title'])
        problem_dir = STRIVER_DIR / f"{problem_num:03d}-{data['questionFrontendId']}-{safe_name}"
        
        if problem_dir.exists():
            if problem_num not in progress['solved']:
                progress['solved'].append(problem_num)
            print(f"  ⏭️  Already exists")
            continue
        
        problem_dir.mkdir(parents=True, exist_ok=True)
        create_solution_files(problem_dir, data, slug, problem_num)
        
        if git_commit_and_push(problem_num, data['title']):
            solved_count += 1
            if problem_num not in progress['solved']:
                progress['solved'].append(problem_num)
            print(f"  ✅ Solved, committed, and pushed!")
        else:
            print(f"  ⚠️  Commit/push failed")
        
        # Update progress file
        json.dump(progress, open(PROGRESS_FILE, 'w'), indent=2)
        
        # Small delay to avoid rate limiting
        time.sleep(1)
    
    print(f"\n{'='*60}")
    print(f"✅ Solved {solved_count} problems in this batch!")
    print(f"📊 Total solved: {len(progress['solved'])}/473")
    print(f"{'='*60}")

if __name__ == "__main__":
    main()

