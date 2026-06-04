# Total Waviness of Numbers in Range I (Medium)

**Problem ID:** 3751  
**Date:** 2026-06-04  
**Link:** https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/

## Approach

To solve the problem of calculating the total waviness of numbers in the inclusive range [num1, num2], we can follow a structured approach:

### Main Idea:
The core idea is to iterate through each number in the specified range and determine its waviness by analyzing its digits. The waviness of a number is defined by counting the peaks and valleys among its digits, where:
- A peak is a digit that is greater than its immediate neighbors.
- A valley is a digit that is less than its immediate neighbors.
- The first and last digits are excluded from being peaks or valleys, and numbers with fewer than three digits have a waviness of zero.

### Steps:
1. **Iterate through the Range**: Loop through each number from `num1` to `num2`.
2. **Convert to Digits**: For each number, convert it into a string or an array of digits to facilitate easy access to individual digits.
3. **Count Waviness**:
   - For each number, if it has three or more digits, check each digit (from the second to the second-last) to see if it is a peak or a valley.
   - Maintain a counter to keep track of the total waviness for that number.
4. **Aggregate Results**: Sum the waviness of all numbers in the range to get the final result.

### Data Structures:
- A simple list or string representation of the digits of the number will suffice for checking peaks and valleys.
- An integer variable to accumulate the total waviness.

### Complexity:
- **Time Complexity**: The approach runs in O(n * d) where `n` is the number of integers in the range [num1, num2] and `d` is the average number of digits in those integers. Given the constraints (with `num2` up to 100,000), this is efficient enough.
- **Space Complexity**: O(d) for storing the digits of each number temporarily during the iteration.

This method effectively counts the waviness for each number in the range while maintaining clarity and efficiency in implementation.
