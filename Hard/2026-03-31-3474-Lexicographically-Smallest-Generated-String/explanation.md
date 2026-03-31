# Lexicographically Smallest Generated String (Hard)

**Problem ID:** 3474  
**Date:** 2026-03-31  
**Link:** https://leetcode.com/problems/lexicographically-smallest-generated-string/

## Approach

To solve the problem of generating the lexicographically smallest string based on the conditions defined by `str1` and `str2`, we can follow these steps:

### Problem Breakdown
1. **Understanding the Constraints**: 
   - For each character in `str1`, if it is 'T', the substring starting at that index in the generated string must match `str2`. If it is 'F', the substring must not match `str2`.
   - The generated string will have a length of `n + m - 1`, where `n` is the length of `str1` and `m` is the length of `str2`.

2. **Initial Setup**:
   - Create an array `word` of size `n + m - 1` initialized with placeholder characters (like `None` or a sentinel character) to represent unfilled positions.

### Approach
1. **Filling the `word` Array**:
   - Traverse `str1` from index 0 to `n - 1`.
   - For each index `i`:
     - If `str1[i]` is 'T', fill the segment `word[i:i+m]` with characters from `str2`. If this segment overlaps with a previously filled segment, check for consistency (i.e., ensure that the existing characters match `str2`).
     - If `str1[i]` is 'F', ensure that the segment `word[i:i+m]` does not match `str2`. If it does, return an empty string immediately. If the segment is already filled, ensure it remains inconsistent with `str2`.

2. **Handling Overlaps**:
   - When filling in segments, be careful with overlaps. If a segment from 'T' overlaps with a segment from 'F', it must be checked for consistency to avoid contradictions.

3. **Lexicographical Order**:
   - To achieve the lexicographically smallest string, when filling segments that can be filled with multiple characters (like in the case of 'F'), choose the smallest possible characters that maintain the constraints.

4. **Finalizing the Output**:
   - Once the `word` array is fully populated without contradictions, convert it to a string and return it.
   - If at any point a contradiction is found, return an empty string.

### Data Structures
- An array (or list) `word` to store the generated characters, which allows for easy indexing and manipulation.

### Complexity Analysis
- **Time Complexity**: O(n * m) in the worst case, as we may need to check up to `m` characters for each of the `n` positions in `str1`.
- **Space Complexity**: O(n + m) for the `word` array.

This approach ensures that we systematically build the generated string while adhering to the constraints and ensuring the result is the smallest possible lexicographically.
