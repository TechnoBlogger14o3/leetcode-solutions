# Fraction to Recurring Decimal (Medium)

**Problem ID:** 166  
**Date:** 2025-09-24  
**Link:** https://leetcode.com/problems/fraction-to-recurring-decimal/

## Approach

To solve the problem of converting a fraction represented by a numerator and denominator into a string format, including handling recurring decimals, we can follow a systematic approach:

### Approach:

1. **Handle Edge Cases**: 
   - If the numerator is 0, the result is simply "0".
   - Handle signs: If the result should be negative, track the signs of the numerator and denominator. The result will be negative if one (and only one) of them is negative.

2. **Integer Division**: 
   - Compute the integer part of the fraction using integer division (`numerator // denominator`). This gives us the whole number part of the result.

3. **Remainder Calculation**: 
   - Calculate the initial remainder using `numerator % denominator`. If the remainder is 0, return the integer part as the result.

4. **Decimal Part Calculation**:
   - Use a loop to calculate the decimal part. For each step, multiply the remainder by 10 and perform integer division by the denominator to get the next digit of the decimal.
   - Update the remainder after each digit calculation.

5. **Detect Recurring Decimals**:
   - Use a hash map (or dictionary) to store the position of each remainder encountered during the decimal calculation. If a remainder repeats, it indicates the start of a recurring cycle.
   - When a repeated remainder is found, use the stored position to determine where to insert parentheses in the result string.

6. **Construct the Result**:
   - Combine the integer part, the decimal part, and handle the recurring section if applicable. Format the final string accordingly.

### Data Structures:
- A string to build the result.
- A hash map (or dictionary) to track the positions of remainders.

### Complexity:
- **Time Complexity**: O(n), where n is the number of digits in the decimal part. This is efficient since we are processing each digit once.
- **Space Complexity**: O(n) in the worst case for storing remainders in the hash map.

This approach ensures that we accurately represent both the integer and decimal parts of the fraction while effectively handling any recurring segments, leading to a correct and formatted string output.
