# Maximize Sum of Squares of Digits (Medium)

**Problem ID:** 3723  
**Date:** 2026-10-14  
**Link:** https://leetcode.com/problems/maximize-sum-of-squares-of-digits/

## Approach

To solve the problem of maximizing the sum of squares of digits for a good integer \( n \) with exactly \( num \) digits and a digit sum of \( sum \), we can follow a systematic approach:

### Main Idea:
The goal is to construct the number \( n \) such that:
1. It has exactly \( num \) digits.
2. The sum of its digits equals \( sum \).
3. The sum of the squares of its digits is maximized.

To maximize the sum of squares, we should prioritize placing larger digits in the most significant positions. This is because squaring larger numbers yields a disproportionately higher value than smaller numbers.

### Steps to Approach:
1. **Feasibility Check**: 
   - First, check if it is possible to form a number with the given constraints. The minimum sum of digits for \( num \) digits is \( num \) (if all digits are 1), and the maximum sum is \( 9 \times num \) (if all digits are 9). If \( sum < num \) or \( sum > 9 \times num \), return an empty string as it's impossible to form such a number.

2. **Construct the Number**:
   - Start from the most significant digit to the least. 
   - For each digit position, assign the maximum possible digit (up to 9) that does not exceed the remaining sum needed to reach \( sum \) and does not cause the total number of digits to exceed \( num \).
   - Deduct the assigned digit from \( sum \) and move to the next position.
   - Ensure that the number has exactly \( num \) digits by filling any remaining positions with zeros if the sum has been exhausted.

3. **Result Formatting**:
   - Once the digits are determined, construct the final number as a string and return it.

### Data Structures:
- A simple list or array can be used to store the digits of the number as they are constructed.

### Complexity:
- **Time Complexity**: \( O(num) \) since we iterate through each digit position exactly once.
- **Space Complexity**: \( O(num) \) for storing the digits in a list.

This approach efficiently constructs the desired number while ensuring that the constraints are met and the score is maximized.
