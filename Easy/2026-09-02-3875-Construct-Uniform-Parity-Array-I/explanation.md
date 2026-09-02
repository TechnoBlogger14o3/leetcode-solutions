# Construct Uniform Parity Array I (Easy)

**Problem ID:** 3875  
**Date:** 2026-09-02  
**Link:** https://leetcode.com/problems/construct-uniform-parity-array-i/

## Approach

To solve the problem of constructing a uniform parity array from the given array `nums1`, we can leverage the properties of even and odd integers.

### Approach:

1. **Understanding Parity**: The goal is to create an array `nums2` where all elements are either even or odd. The parity of a number can be determined by its remainder when divided by 2: even numbers yield a remainder of 0, while odd numbers yield a remainder of 1.

2. **Choices for `nums2`**: For each element `nums1[i]`, we have two choices:
   - Use `nums1[i]` directly.
   - Use the expression `nums1[i] - nums1[j]` for some `j != i`.

3. **Analyzing the Expression**: The expression `nums1[i] - nums1[j]` will have the same parity as `nums1[i]` if both `nums1[i]` and `nums1[j]` are either even or odd. If one is even and the other is odd, the result will be odd.

4. **Count Parity**: We can count the number of even and odd integers in `nums1`:
   - If all integers in `nums1` are even, we can directly construct `nums2` with all even integers.
   - If all integers in `nums1` are odd, we can construct `nums2` with all odd integers.
   - If there is at least one even and one odd integer, we can use the differences to create a uniform parity array.

5. **Conclusion**: The solution can be summarized as follows:
   - If the count of even integers is greater than 0 and the count of odd integers is greater than 0, return `true`.
   - If all integers are even or all are odd, return `true`.
   - The only situation where it's impossible to construct `nums2` is when `nums1` contains both even and odd integers, but we can always construct a uniform parity array in such cases.

### Data Structures:
- A simple integer counter for even and odd counts.

### Complexity:
- **Time Complexity**: O(n), where n is the length of `nums1`, since we only need to iterate through the list once to count the parity.
- **Space Complexity**: O(1), as we are only using a few integer variables for counting.

By following this approach, we can efficiently determine if constructing a uniform parity array is possible.
