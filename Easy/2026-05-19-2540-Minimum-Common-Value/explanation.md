# Minimum Common Value (Easy)

**Problem ID:** 2540  
**Date:** 2026-05-19  
**Link:** https://leetcode.com/problems/minimum-common-value/

## Approach

To solve the problem of finding the minimum common value between two sorted arrays, we can utilize a two-pointer technique, which is efficient given that both arrays are already sorted. 

### Approach:
1. **Initialization**: Start with two pointers, `i` for `nums1` and `j` for `nums2`, both initialized to the beginning of their respective arrays.

2. **Iterate through both arrays**:
   - Compare the elements pointed to by `i` and `j`:
     - If `nums1[i]` is less than `nums2[j]`, increment `i` to move to the next element in `nums1`.
     - If `nums1[i]` is greater than `nums2[j]`, increment `j` to move to the next element in `nums2`.
     - If `nums1[i]` is equal to `nums2[j]`, we have found a common value. Since both arrays are sorted, this is the smallest common value encountered so far. Return this value immediately.

3. **Termination**: If we exhaust one of the arrays without finding a common value, return -1 to indicate that no common integer exists.

### Data Structures:
- We primarily use two integer pointers (`i` and `j`) to traverse the arrays. This approach does not require any additional data structures, making it space-efficient.

### Complexity:
- **Time Complexity**: O(n + m), where n is the length of `nums1` and m is the length of `nums2`. In the worst case, we may need to traverse both arrays entirely.
- **Space Complexity**: O(1), as we are only using a constant amount of extra space for the pointers.

This method efficiently finds the minimum common value by leveraging the sorted property of the arrays, ensuring both time and space efficiency in the solution.
