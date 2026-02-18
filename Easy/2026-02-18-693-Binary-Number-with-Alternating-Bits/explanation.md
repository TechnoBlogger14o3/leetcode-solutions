# Binary Number with Alternating Bits (Easy)

**Problem ID:** 693  
**Date:** 2026-02-18  
**Link:** https://leetcode.com/problems/binary-number-with-alternating-bits/

## Approach

To solve the problem of determining whether a given positive integer has alternating bits in its binary representation, we can follow a straightforward approach:

### Main Idea:
The core idea is to check each bit of the integer's binary representation to see if it alternates between 0 and 1. This can be efficiently achieved by using bit manipulation.

### Approach:
1. **Bitwise Operations**: We can use the right shift operation to examine each bit of the number. By shifting the number to the right, we can compare each bit with the next one.
  
2. **Masking**: We can also use a mask to isolate the last bit and compare it with the previous bit. If two adjacent bits are the same, we can immediately conclude that the number does not have alternating bits.

3. **Iterate through bits**: Start from the least significant bit (LSB) and check if it differs from the next bit. If they are the same at any point, return false.

4. **Final Check**: If we finish checking all bits without finding two adjacent bits that are the same, return true.

### Data Structures:
- No complex data structures are needed; we primarily use integer variables for the input and temporary storage during bit manipulation.

### Complexity:
- **Time Complexity**: O(log n), where n is the input number. This is because we are examining each bit of the number, and the number of bits in a number is proportional to the logarithm of the number.
- **Space Complexity**: O(1), as we are using a constant amount of space regardless of the input size.

In summary, by leveraging bitwise operations, we can efficiently determine if the integer has alternating bits by checking each bit against its neighbor, ensuring a clear and concise solution to the problem.
