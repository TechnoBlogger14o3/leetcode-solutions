# Compare Version Numbers (Medium)

**Problem ID:** 165  
**Date:** 2025-09-23  
**Link:** https://leetcode.com/problems/compare-version-numbers/

## Approach

To solve the problem of comparing version numbers represented as strings, we can follow a systematic approach:

### Main Idea:
The goal is to compare two version strings, `version1` and `version2`, by breaking them down into their individual revision components (separated by dots) and comparing these components as integers. Leading zeros in the revision numbers should be ignored.

### Approach:
1. **Splitting the Version Strings**: 
   - Use the `split` method to divide both version strings into lists of strings based on the dot ('.') delimiter. This will give us a list of revisions for each version.

2. **Normalization**:
   - Convert each revision from the string format to an integer. This will automatically handle leading zeros since converting a string like "01" to an integer will yield `1`.

3. **Iterative Comparison**:
   - Determine the maximum length of the two lists of revisions. Iterate through each revision index up to this maximum length.
   - For each index:
     - If one list has a revision at the current index and the other does not, treat the missing revision as `0`.
     - Compare the integer values of the revisions at the current index:
       - If `version1`'s revision is greater, return `1`.
       - If `version2`'s revision is greater, return `-1`.

4. **Final Check**:
   - If all compared revisions are equal, return `0`.

### Data Structures:
- Two lists (arrays) to hold the split revisions of `version1` and `version2`.
- Integer variables to hold the converted revision values during comparison.

### Complexity:
- **Time Complexity**: O(n + m), where `n` is the number of revisions in `version1` and `m` is the number of revisions in `version2`. This accounts for the time taken to split the strings and to compare the revisions.
- **Space Complexity**: O(n + m) for storing the split revisions.

This approach ensures that we handle different lengths of version strings and leading zeros effectively, providing a clear and efficient solution to the problem.
