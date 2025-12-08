#!/usr/bin/env python3
"""
Extract problems from DSA Sheets.pdf
Hybrid approach: extract all problems, improve slug extraction
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
    
    # First pass: Extract all LeetCode URLs with complete slugs
    # Normalize text to handle line breaks in URLs
    normalized_text = full_text.replace('\n', ' ').replace('  ', ' ')
    
    # Find all complete LeetCode URLs
    leetcode_pattern = r'(?:https?://)?(?:www\.)?leetcode\.com/problems/([a-z0-9-]+)/?'
    all_slug_matches = {}
    for match in re.finditer(leetcode_pattern, normalized_text, re.IGNORECASE):
        slug = match.group(1).lower()
        # Only keep complete slugs (more than 5 chars, doesn't end with hyphen)
        if len(slug) > 5 and not slug.endswith('-'):
            # Get context to find problem number
            start = max(0, match.start() - 100)
            end = min(len(normalized_text), match.end() + 50)
            context = normalized_text[start:end]
            # Try to find problem number nearby
            num_match = re.search(r'\b(\d{1,3})\.?\s', context)
            if num_match:
                problem_num = int(num_match.group(1))
                if slug not in all_slug_matches:
                    all_slug_matches[slug] = problem_num
    
    print(f"Found {len(all_slug_matches)} complete LeetCode slugs with problem numbers")
    
    # Second pass: Extract problems line by line (original method)
    lines = full_text.split('\n')
    current_category = None
    problem_num = 0
    
    for i, line in enumerate(lines):
        line = line.strip()
        if not line:
            continue
            
        # Detect category headers
        if len(line) > 3 and line.isupper() and len(line.split()) < 10:
            current_category = line
            print(f"Found category: {current_category}")
            continue
        
        # Look for problem numbers
        problem_match = re.match(r'^(\d+)\.?\s*(.+)', line)
        if problem_match:
            num = problem_match.group(1)
            rest = problem_match.group(2).strip()
            
            # Build search text from current line and next 2 lines (for split URLs)
            search_text = line
            for j in range(i+1, min(i+3, len(lines))):
                if lines[j].strip():
                    search_text += " " + lines[j].strip()
            
            # Normalize for URL matching (remove spaces that might break URLs)
            search_normalized = re.sub(r'([a-z0-9-])\s+([a-z0-9-])', r'\1\2', search_text, flags=re.IGNORECASE)
            
            # Try to extract LeetCode link
            link_match = re.search(leetcode_pattern, search_normalized, re.IGNORECASE)
            title_slug = None
            if link_match:
                potential_slug = link_match.group(1).lower()
                # Only use if it's a complete slug
                if len(potential_slug) > 5 and not potential_slug.endswith('-'):
                    title_slug = potential_slug
            
            # Also check if this problem number has a slug in our map
            if not title_slug and int(num) in all_slug_matches.values():
                # Find slug for this problem number
                for slug, pnum in all_slug_matches.items():
                    if pnum == int(num):
                        title_slug = slug
                        break
            
            # Extract problem title
            title = re.sub(r'https?://[^\s]+', '', rest).strip()
            title = re.sub(r'\([^)]*\)', '', title).strip()
            title = re.sub(r'\[.*?\]', '', title).strip()
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
    
    # Add any slugs we found that weren't in the numbered list
    existing_slugs = {p.get("title_slug") for p in problems if p.get("title_slug")}
    for slug, pnum in all_slug_matches.items():
        if slug not in existing_slugs:
            # Check if we already have this problem number
            existing_for_num = [p for p in problems if p["number"] == pnum]
            if not existing_for_num:
                problem_num += 1
                problems.append({
                    "number": problem_num,
                    "category": "Unknown",
                    "title": slug.replace('-', ' ').title(),
                    "title_slug": slug,
                    "raw_line": f"leetcode.com/problems/{slug}"
                })
    
    # Count problems with slugs
    with_slugs = [p for p in problems if p.get("title_slug") and len(p["title_slug"]) > 5]
    print(f"\nProblems with valid slugs: {len(with_slugs)}")
    print(f"Total problems extracted: {len(problems)}")
    
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
