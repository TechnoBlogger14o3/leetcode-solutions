# Rotated Digits (Medium)

**Problem ID:** 788  
**Date:** 2026-05-02  
**Link:** https://leetcode.com/problems/rotated-digits/

## Approach

To solve the "Rotated Digits" problem, we need to determine how many integers in the range [1, n] are "good" based on the rotation rules provided. A number is classified as "good" if, after rotating each of its digits by 180 degrees, it results in a valid number that is different from the original number.

### Approach:

1. **Understanding Digit Rotation**:
   - We first identify which digits are valid after rotation:
     - Valid digits: 0, 1, 8 (remain the same)
     - Valid pairs: 2 ↔ 5, 6 ↔ 9
     - Invalid digits: 3, 4, 7 (become invalid)
   - A "good" number must contain at least one of the digits that change (2, 5, 6, or 9) and must not consist solely of valid digits that remain unchanged (0, 1, 8).

2. **Iterate Through the Range**:
   - We will iterate through each number from 1 to n and check its digits.
   - For each number, we will convert it to its string representation to easily access each digit.

3. **Check Each Digit**:
   - For each digit in the number:
     - If any digit is invalid (3, 4, 7), we can skip to the next number.
     - If we encounter a digit that changes (2, 5, 6, or 9), we mark this number as "good".

4. **Count Good Numbers**:
   - Maintain a counter to keep track of how many "good" numbers we find during our iteration.

### Data Structures:
- We primarily use a simple integer counter to track the number of good numbers.
- String representation of numbers allows for easy digit access and checking.

### Complexity:
- **Time Complexity**: O(n * d), where n is the input number and d is the number of digits in n. In the worst case, d is log10(n), making the complexity effectively O(n) for the upper limit of n (10,000).
- **Space Complexity**: O(1), as we only use a few variables to store counts and check digits.

By following this structured approach, we can efficiently determine the count of good integers in the specified range.
