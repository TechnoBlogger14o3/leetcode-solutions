# Plus One (Easy)

**Problem ID:** 66  
**Date:** 2026-01-01  
**Link:** https://leetcode.com/problems/plus-one/

## Approach

To solve the "Plus One" problem, we need to increment a large integer represented as an array of its digits. The main idea is to simulate the process of addition, starting from the least significant digit (the rightmost element of the array) and moving towards the most significant digit (the leftmost element).

### Approach:

1. **Initialization**: Start from the last digit of the array. This is where the increment will first take effect.

2. **Increment and Carry**: 
   - Add one to the last digit.
   - If this results in a value less than 10, simply update the digit and return the array, as no further carry is needed.
   - If the result is 10, set the current digit to 0 (because we have a carry) and move to the next digit to the left.

3. **Handling Carry**: Continue this process for each digit:
   - If a digit becomes 0 after adding the carry, repeat the carry operation for the next digit.
   - If you reach the most significant digit and it also results in a carry (e.g., from 9 to 10), you will need to insert a new digit at the beginning of the array (i.e., prepend 1).

4. **Return Result**: Once all digits are processed, return the modified array.

### Data Structures:
- The solution primarily uses an array to represent the digits of the number. No additional complex data structures are needed.

### Complexity:
- **Time Complexity**: O(n), where n is the number of digits in the array. In the worst case, we may need to traverse the entire array if there are multiple carries.
- **Space Complexity**: O(1) if we ignore the output array, as we are modifying the input array in place. If a new digit is added, it can be considered O(n) in terms of the output size.

This approach efficiently handles the addition while respecting the constraints of the problem, ensuring that the solution is both straightforward and optimal.
