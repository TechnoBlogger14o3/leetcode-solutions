# Check If Digits Are Equal in String After Operations I (Easy)

**Problem ID:** 3461  
**Date:** 2025-10-23  
**Link:** https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/

## Approach

To solve the problem of checking if the final two digits in the string `s` are the same after performing a series of operations, we can follow a systematic approach:

### Main Idea
The core idea is to repeatedly transform the string by summing each pair of consecutive digits modulo 10 until we are left with only two digits. The final step is to check if these two digits are equal.

### Steps to Approach
1. **Iterative Transformation**: Start with the input string `s`. In each iteration, create a new string by calculating the sum of each pair of consecutive digits, applying the modulo 10 operation. This will reduce the length of the string by one with each operation.

2. **Repeat Until Two Digits**: Continue the transformation until the string is reduced to exactly two digits.

3. **Final Comparison**: Once we have the final two digits, simply compare them to determine if they are equal.

### Data Structures
- The main data structure used is a string (or list) to hold the digits during each transformation. The operations primarily involve manipulating this string.

### Complexity Analysis
- **Time Complexity**: Each transformation step involves iterating through the string and performing a constant-time operation (addition and modulo) for each pair of digits. Given that the maximum length of `s` is 100, the number of iterations will be logarithmic with respect to the length of `s`. Therefore, the overall time complexity can be approximated as O(n^2) in the worst case, where `n` is the initial length of the string.
  
- **Space Complexity**: The space complexity is O(n) for storing the new string during each transformation step.

### Conclusion
This approach is efficient for the given constraints, and by focusing on the iterative reduction of the string and the final comparison of the last two digits, we can determine the result effectively.
