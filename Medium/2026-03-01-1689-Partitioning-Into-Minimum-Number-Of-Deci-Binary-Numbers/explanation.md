# Partitioning Into Minimum Number Of Deci-Binary Numbers (Medium)

**Problem ID:** 1689  
**Date:** 2026-03-01  
**Link:** https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

## Approach

To solve the problem of partitioning a positive decimal integer \( n \) into the minimum number of deci-binary numbers, we can leverage the properties of the digits in \( n \).

### Main Idea:
The key insight is that each digit in \( n \) can be represented as a sum of deci-binary numbers, where each deci-binary number has only the digits 0 and 1. The maximum digit in \( n \) dictates the minimum number of deci-binary numbers required. For example, if the maximum digit is 8, we can form 8 deci-binary numbers (like 11111111) to achieve the sum.

### Approach:
1. **Identify the Maximum Digit**: Iterate through the digits of the string \( n \) to find the maximum digit. This digit represents the highest count of deci-binary numbers needed because we can only use digits 0 and 1 in our deci-binary numbers.
  
2. **Count Deci-Binary Numbers**: The result will be equal to the maximum digit found. This is because, for each digit \( d \) in \( n \), we can create \( d \) deci-binary numbers to satisfy that digit's contribution to the overall sum.

### Data Structures:
- A simple integer variable to keep track of the maximum digit found during the iteration through the string.

### Complexity:
- **Time Complexity**: \( O(k) \), where \( k \) is the length of the string \( n \). We need to iterate through each digit once.
- **Space Complexity**: \( O(1) \), as we are only using a constant amount of space for the maximum digit variable.

### Conclusion:
By focusing on the maximum digit in the number \( n \), we can efficiently determine the minimum number of deci-binary numbers needed to sum up to \( n \). This approach is both straightforward and optimal given the constraints.
