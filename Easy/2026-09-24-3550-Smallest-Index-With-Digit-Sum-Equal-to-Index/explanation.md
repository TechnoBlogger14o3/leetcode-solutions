# Smallest Index With Digit Sum Equal to Index (Easy)

**Problem ID:** 3550  
**Date:** 2026-09-24  
**Link:** https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/

## Approach

To solve the problem of finding the smallest index \( i \) such that the sum of the digits of \( nums[i] \) equals \( i \), we can follow a straightforward approach:

### Approach:

1. **Iterate Through the Array**: We will loop through each index \( i \) of the given array `nums`.

2. **Calculate the Digit Sum**: For each element \( nums[i] \), we need to calculate the sum of its digits. This can be done by repeatedly extracting the last digit (using modulus operation) and summing them up until the number becomes zero.

3. **Check Condition**: After calculating the digit sum for \( nums[i] \), we check if this sum is equal to the index \( i \).

4. **Return the Result**: As soon as we find an index \( i \) that satisfies the condition, we can return \( i \). If we finish the loop without finding such an index, we return -1.

### Data Structures:
- We primarily use an integer array `nums` to store the input values.
- We can use simple integer variables to store the current index and the digit sum during calculations.

### Complexity:
- **Time Complexity**: The overall time complexity is \( O(n \cdot d) \), where \( n \) is the length of the array and \( d \) is the maximum number of digits in the numbers in the array. Given the constraints (maximum \( nums[i] \) is 1000), \( d \) is at most 4. Thus, the complexity can be approximated to \( O(n) \) for practical purposes.
- **Space Complexity**: The space complexity is \( O(1) \) since we are using a constant amount of extra space regardless of the input size.

This approach is efficient given the problem's constraints and ensures that we find the smallest index that meets the criteria in a single pass through the array.
