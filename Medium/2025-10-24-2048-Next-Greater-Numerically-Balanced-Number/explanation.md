# Next Greater Numerically Balanced Number (Medium)

**Problem ID:** 2048  
**Date:** 2025-10-24  
**Link:** https://leetcode.com/problems/next-greater-numerically-balanced-number/

## Approach

To solve the problem of finding the next greater numerically balanced number, we can follow a systematic approach that combines brute-force checking with a structured way to generate potential candidates.

### Main Idea
The core idea is to generate numbers greater than `n` and check if they are numerically balanced. A number is numerically balanced if for every digit `d` in the number, the digit `d` appears exactly `d` times. 

### Approach
1. **Incremental Search**: Start from `n + 1` and incrementally check each number to see if it is numerically balanced. This ensures that we find the smallest number that meets the criteria.

2. **Digit Count Validation**:
   - For each candidate number, convert it to a string to easily access its digits.
   - Use a frequency array or dictionary to count occurrences of each digit.
   - After counting, validate that for each digit `d` that appears in the number, it occurs exactly `d` times. If any digit fails this condition, the number is not balanced.

3. **Efficiency Considerations**:
   - Since the maximum value for `n` is `10^6`, the search space is manageable. However, the brute-force checking may still require optimization.
   - Instead of checking every number, we can skip numbers that contain digits greater than 9 or 0, as they cannot be balanced (e.g., a digit `0` cannot appear).

4. **Data Structures**: 
   - Use an array of size 10 (for digits 0-9) to count occurrences of each digit efficiently. This allows for quick access and updates during the counting process.

### Complexity
- **Time Complexity**: In the worst case, we may check multiple numbers until we find a balanced one. Each number requires checking its digits, leading to a complexity of O(d) per number, where d is the number of digits in the number. Overall, the complexity can be approximated as O(k * d), where k is the number of candidates checked.
- **Space Complexity**: The space used for the digit count array is O(1) since it always has a fixed size of 10.

### Summary
The solution involves incrementally searching for the next greater number while validating each candidate for the numerically balanced condition using a digit count. This approach leverages simple counting and validation techniques to ensure correctness while remaining efficient given the constraints.
