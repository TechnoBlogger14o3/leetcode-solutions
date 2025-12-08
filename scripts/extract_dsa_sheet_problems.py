#!/usr/bin/env python3
"""
Extract problems from DSA Sheets.pdf
"""
import pdfplumber
import re
from pathlib import Path
import json

ROOT = Path(__file__).resolve().parents[1]
PDF_PATH = ROOT / "DSA Sheets.pdf"
OUTPUT_JSON = ROOT / "striver_sde_sheet_problems.json"

def extract_problems_from_pdf():
    """Extract all problems from the PDF"""
    problems = []
    
    print(f"Reading PDF: {PDF_PATH}")
    with pdfplumber.open(PDF_PATH) as pdf:
        full_text = ""
        for page_num, page in enumerate(pdf.pages, 1):
            text = page.extract_text()
            if text:
                full_text += text + "\n"
            if page_num % 10 == 0:
                print(f"Processed {page_num} pages...")
    
    print(f"Total pages: {len(pdf.pages)}")
    print(f"Extracted text length: {len(full_text)} characters")
    
    # Try to find problem patterns
    # Common patterns: Problem numbers, LeetCode links, problem titles
    
    # Pattern 1: LeetCode problem links (leetcode.com/problems/...)
    leetcode_pattern = r'leetcode\.com/problems/([a-z0-9-]+)'
    leetcode_matches = re.findall(leetcode_pattern, full_text, re.IGNORECASE)
    
    # Pattern 2: Problem numbers (like "1.", "2.", etc.)
    # Pattern 3: Problem titles (usually after numbers)
    
    # Split by lines and look for structured data
    lines = full_text.split('\n')
    
    current_category = None
    problem_num = 0
    
    for i, line in enumerate(lines):
        line = line.strip()
        if not line:
            continue
            
        # Detect category headers (usually in caps or bold)
        if len(line) > 3 and line.isupper() and len(line.split()) < 10:
            current_category = line
            print(f"Found category: {current_category}")
            continue
        
        # Look for problem numbers (1., 2., etc.) or LeetCode problem IDs
        # Pattern: Number followed by problem name or LeetCode link
        problem_match = re.match(r'^(\d+)\.?\s*(.+)', line)
        if problem_match:
            num = problem_match.group(1)
            rest = problem_match.group(2).strip()
            
            # Try to extract LeetCode link if present (capture full slug)
            link_match = re.search(r'leetcode\.com/problems/([a-z0-9-]+)/?', rest, re.IGNORECASE)
            title_slug = link_match.group(1) if link_match else None
            # Also check if slug is incomplete in the line
            if title_slug and len(title_slug) < 5:
                # Might be incomplete, try to get more from next lines
                title_slug = None
            
            # Extract problem title (text before link or special chars)
            title = re.sub(r'https?://[^\s]+', '', rest).strip()
            title = re.sub(r'\([^)]*\)', '', title).strip()  # Remove parentheses
            if not title and title_slug:
                title = title_slug.replace('-', ' ').title()
            
            if title or title_slug:
                problem_num += 1
                problem = {
                    "number": problem_num,
                    "category": current_category or "Unknown",
                    "title": title,
                    "title_slug": title_slug,
                    "raw_line": line
                }
                problems.append(problem)
                if problem_num % 50 == 0:
                    print(f"Extracted {problem_num} problems...")
    
    # Also try to extract from LeetCode links directly
    unique_slugs = list(set(leetcode_matches))
    print(f"\nFound {len(unique_slugs)} unique LeetCode problem slugs")
    
    # Merge with existing problems
    existing_slugs = {p.get("title_slug") for p in problems if p.get("title_slug")}
    for slug in unique_slugs:
        if slug not in existing_slugs:
            problem_num += 1
            problems.append({
                "number": problem_num,
                "category": "Unknown",
                "title": slug.replace('-', ' ').title(),
                "title_slug": slug,
                "raw_line": f"leetcode.com/problems/{slug}"
            })
    
    print(f"\nTotal problems extracted: {len(problems)}")
    return problems

def save_problems(problems):
    """Save problems to JSON file"""
    with open(OUTPUT_JSON, 'w', encoding='utf-8') as f:
        json.dump(problems, f, indent=2, ensure_ascii=False)
    print(f"Saved {len(problems)} problems to {OUTPUT_JSON}")

if __name__ == "__main__":
    problems = extract_problems_from_pdf()
    save_problems(problems)
    print(f"\n✅ Extraction complete! Found {len(problems)} problems")

