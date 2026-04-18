# Mirror Distance of an Integer (Easy)

**Problem ID:** 3783  
**Date:** 2026-04-18  
**Link:** https://leetcode.com/problems/mirror-distance-of-an-integer/

## Approach

To solve the problem of calculating the mirror distance of an integer \( n \), we can follow a straightforward approach that involves reversing the digits of the integer and then computing the absolute difference between \( n \) and its reversed value.

### Approach:

1. **Reverse the Integer**:
   - Convert the integer \( n \) to a string to easily manipulate its digits.
   - Reverse the string representation of \( n \) and convert it back to an integer. This handles leading zeros automatically since converting back to an integer will discard any leading zeros.

2. **Calculate the Mirror Distance**:
   - Once we have the reversed integer, we can compute the mirror distance using the formula: 
     \[
     \text{mirror distance} = |n - \text{reverse}(n)|
     \]
   - Use the absolute value function to ensure the result is non-negative.

### Data Structures:
- We primarily use a string to facilitate the reversal of digits. The integer values are handled directly for computation.

### Complexity:
- **Time Complexity**: The time complexity is \( O(d) \), where \( d \) is the number of digits in \( n \). Since \( n \) can be at most \( 10^9 \), \( d \) will be at most 10.
- **Space Complexity**: The space complexity is \( O(d) \) due to the storage of the string representation of \( n \).

### Summary:
The main idea is to reverse the digits of the integer \( n \) and compute the absolute difference from the original integer. This approach is efficient given the constraints and leverages simple string manipulation to achieve the desired result.
