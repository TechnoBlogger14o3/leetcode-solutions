# Total Waviness of Numbers in Range II (Hard)

**Problem ID:** 3753  
**Date:** 2026-06-05  
**Link:** https://leetcode.com/problems/total-waviness-of-numbers-in-range-ii/

## Approach

To solve the problem of calculating the total waviness of numbers in the range [num1, num2], we can break down the approach as follows:

### Main Idea:
The core of the solution revolves around iterating through each number in the specified range and determining the waviness for each number. The waviness is defined by counting the peaks and valleys of its digits. A peak is a digit that is greater than its immediate neighbors, while a valley is a digit that is less than its neighbors. 

### Steps to Solve the Problem:
1. **Iterate Over the Range**: Loop through each integer from `num1` to `num2`.
2. **Convert to Digits**: For each number, convert it to a string or array of digits to facilitate easy access to individual digits.
3. **Count Waviness**:
   - For numbers with fewer than three digits, immediately assign a waviness of 0.
   - For numbers with three or more digits, iterate through the digits (from the second to the second-to-last) and check for peaks and valleys:
     - If a digit is greater than both its neighbors, increment the peak count.
     - If a digit is less than both its neighbors, increment the valley count.
4. **Aggregate Results**: Sum the waviness counts for all numbers in the range to get the final result.

### Data Structures:
- **Array/Strings**: To store the digits of each number for easy comparison.
- **Integer Variables**: To keep track of the current number's waviness and the total waviness across the range.

### Complexity:
- **Time Complexity**: The algorithm runs in O(d * n), where `n` is the number of integers in the range [num1, num2] and `d` is the average number of digits in those integers. Given that `num2` can be as large as 10^15, the maximum number of digits is 16. Thus, the solution is efficient for the given constraints.
- **Space Complexity**: O(d) for storing the digits of the current number, which is manageable given the constraints.

This approach effectively balances simplicity and efficiency, allowing us to compute the total waviness without unnecessary complexity.
