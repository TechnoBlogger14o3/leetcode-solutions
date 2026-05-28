# Longest Common Suffix Queries (Hard)

**Problem ID:** 3093  
**Date:** 2026-05-28  
**Link:** https://leetcode.com/problems/longest-common-suffix-queries/

## Approach

To solve the problem of finding the longest common suffix between strings in `wordsContainer` and `wordsQuery`, we can adopt a systematic approach that leverages efficient string manipulation and data organization.

### Approach:

1. **Suffix Comparison**: For each query in `wordsQuery`, we need to compare it against all strings in `wordsContainer` to find the longest common suffix. This can be done by iterating through the characters of the strings from the end towards the beginning.

2. **Data Structures**:
   - We can maintain a result list `ans` to store the index of the best matching string for each query.
   - We will keep track of the longest common suffix length found so far, the corresponding index of the string in `wordsContainer`, and the length of that string to resolve ties based on length.

3. **Iterative Comparison**:
   - For each string in `wordsContainer`, we compare it with the current query string character by character from the end. 
   - We keep track of how many characters match (the length of the common suffix).
   - If we find a longer common suffix, we update our best match. If the lengths are equal, we check the lengths of the strings to find the smallest one, and if still tied, we prefer the one that appeared first in `wordsContainer`.

4. **Complexity Considerations**:
   - The worst-case time complexity is O(n * m), where n is the number of strings in `wordsContainer` and m is the average length of the strings. Given the constraints, this approach is feasible since we are only iterating through each string and its suffixes once per query.

5. **Final Output**:
   - After processing all queries, we return the `ans` list containing the indices of the best matching strings.

### Summary:
This approach efficiently finds the longest common suffix for each query by leveraging character-by-character comparison from the end of the strings, ensuring that we also handle ties based on string length and order of appearance. The overall complexity is manageable within the given constraints, making this method suitable for the problem at hand.
