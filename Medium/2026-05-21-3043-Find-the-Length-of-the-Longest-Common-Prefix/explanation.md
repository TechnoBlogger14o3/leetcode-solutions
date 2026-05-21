# Find the Length of the Longest Common Prefix (Medium)

**Problem ID:** 3043  
**Date:** 2026-05-21  
**Link:** https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/

## Approach

To solve the problem of finding the length of the longest common prefix between all pairs of integers from two arrays `arr1` and `arr2`, we can follow a systematic approach:

### Approach:

1. **Understanding Common Prefix**: A common prefix between two integers is formed by comparing their digits from the leftmost side until they differ. The goal is to find the maximum length of such prefixes across all pairs formed by elements from `arr1` and `arr2`.

2. **Iterate Through All Pairs**: We need to compare each integer in `arr1` with each integer in `arr2`. Given the constraints, this results in a maximum of \(5 \times 10^4 \times 5 \times 10^4 = 2.5 \times 10^9\) comparisons, which is not feasible for direct pairwise comparison due to time complexity.

3. **Optimized Comparison**: Instead of comparing every possible pair, we can optimize the comparison:
   - For each integer in `arr1`, convert it to a string and compare it with each integer in `arr2` (also converted to a string).
   - Use a helper function to determine the length of the common prefix between two strings. This function will iterate through the characters of both strings until a mismatch is found.

4. **Maintain Maximum Length**: As we compute the common prefix lengths for each pair, we keep track of the maximum length found.

5. **Return Result**: After all comparisons, the maximum length of the common prefix is returned. If no common prefix exists, the result will naturally be 0.

### Data Structures:
- Use simple lists to store the integers from `arr1` and `arr2`.
- Strings are used for the comparison of digits.

### Complexity:
- The time complexity of this approach is \(O(n \cdot m \cdot k)\), where \(n\) is the length of `arr1`, \(m\) is the length of `arr2`, and \(k\) is the maximum length of the integer strings being compared. Given the constraints, this is efficient enough, especially since the maximum length of the integers (up to 8 digits) keeps the inner comparison manageable.

This approach effectively balances the need for thoroughness in checking all pairs while leveraging string manipulation to efficiently determine common prefixes.
