# Separate the Digits in an Array (Easy)

**Problem ID:** 2553  
**Date:** 2026-05-11  
**Link:** https://leetcode.com/problems/separate-the-digits-in-an-array/

## Approach

To solve the problem of separating the digits in an array of positive integers, we can follow a straightforward approach that leverages basic iteration and string manipulation.

### Approach:

1. **Initialization**: Start by creating an empty list to hold the final result, which will store the separated digits.

2. **Iterate Through the Input Array**: Loop through each integer in the input array `nums`. For each integer:
   - Convert the integer to a string. This allows us to easily access each digit as a character.
   - For each character in the string representation of the integer, convert it back to an integer and append it to the result list.

3. **Return the Result**: After processing all integers, return the list containing the separated digits.

### Data Structures:
- **List**: We use a list to store the resulting digits since it allows for dynamic resizing and easy appending of elements.

### Complexity Analysis:
- **Time Complexity**: O(n * d), where `n` is the number of integers in the input array and `d` is the maximum number of digits in any integer. In the worst case, since `d` can be at most 6 (for numbers up to 100,000), the overall complexity can be approximated to O(n) for practical purposes.
- **Space Complexity**: O(m), where `m` is the total number of digits across all integers in the input array. This is because we store each digit in the result list.

This approach is efficient given the constraints, and it ensures that we maintain the order of digits as they appear in the original integers.
