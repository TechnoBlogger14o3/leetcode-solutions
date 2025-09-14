# Vowel Spellchecker (Medium)

**Problem ID:** 966  
**Date:** 2025-09-14  
**Link:** https://leetcode.com/problems/vowel-spellchecker/

## Approach

To solve the "Vowel Spellchecker" problem, we can adopt a systematic approach that leverages data structures for efficient lookups and transformations. Here’s a concise explanation of the approach:

### Main Idea
The goal is to implement a spellchecker that can correct queries based on a provided wordlist, handling both capitalization and vowel errors. The solution involves three main checks for each query: exact match, case-insensitive match, and vowel-error match.

### Steps to Approach

1. **Data Structures**:
   - Use a dictionary (hash map) to store the words from the wordlist. This allows for O(1) average time complexity for lookups.
   - Maintain a second dictionary to map a transformed version of each word (with vowels replaced) to its original form. This will help in handling vowel errors efficiently.

2. **Preprocessing**:
   - Iterate through the wordlist and populate the two dictionaries:
     - The first dictionary maps each word to itself (for exact matches).
     - The second dictionary maps the vowel-replaced version of each word (where 'a', 'e', 'i', 'o', 'u' are replaced by a placeholder, e.g., '*') to the original word. This allows us to quickly check for vowel errors.

3. **Query Processing**:
   - For each query, perform the following checks in order:
     - **Exact Match**: Check if the query exists in the first dictionary. If found, return the exact match.
     - **Case-Insensitive Match**: Convert the query to lowercase and check for existence in the first dictionary. If found, return the corresponding word with the original case.
     - **Vowel Error Match**: Transform the query into its vowel-replaced version and check the second dictionary. If found, return the corresponding word with the original case.

4. **Return Results**:
   - If none of the checks yield a match, return an empty string for that query.

### Complexity Analysis
- **Time Complexity**: 
  - Preprocessing the wordlist takes O(n * m), where n is the number of words in the wordlist and m is the maximum length of a word (up to 7).
  - Each query check involves O(m) operations for transformation, leading to O(q * m) for q queries.
  - Overall complexity: O(n * m + q * m).

- **Space Complexity**: 
  - The space used by the two dictionaries is O(n * m) for storing the words and their transformed versions.

This structured approach ensures that we efficiently handle the various types of matches required by the problem while maintaining clarity in the logic and operations performed.
