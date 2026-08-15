# Longest Subsequence With Non-Zero Bitwise XOR (Medium)

**Problem ID:** 3702  
**Date:** 2026-08-15  
**Link:** https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/

## Approach

To solve the problem of finding the longest subsequence in an array `nums` such that the bitwise XOR of the subsequence is non-zero, we can follow a straightforward approach based on the properties of XOR.

### Main Idea:
1. **Understanding XOR**: The XOR operation results in a non-zero value unless all bits in the operands are identical. Thus, if we have a subsequence that includes at least one element that is not zero, we can potentially achieve a non-zero XOR.
  
2. **Subsequence Selection**: The key insight is that the longest subsequence with a non-zero XOR can be formed by including all non-zero elements of the array. This is because the XOR of multiple non-zero numbers can yield a non-zero result.

3. **Handling Zeros**: If the array contains only zeros, the longest subsequence with a non-zero XOR is impossible, and we should return 0. If there are non-zero elements, we can include all of them to form the longest valid subsequence.

### Approach:
- Count the number of non-zero elements in the array.
- If the count of non-zero elements is greater than zero, the length of the longest subsequence with a non-zero XOR is equal to the count of these non-zero elements.
- If there are no non-zero elements, return 0.

### Data Structures:
- A simple integer counter can be used to track the number of non-zero elements.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the `nums` array. We need to iterate through the array once to count non-zero elements.
- **Space Complexity**: O(1), as we are using a constant amount of extra space regardless of the input size.

This approach efficiently determines the length of the longest subsequence with a non-zero bitwise XOR by leveraging the properties of the XOR operation and counting non-zero elements.
