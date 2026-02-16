# Reverse Bits (Easy)

**Problem ID:** 190  
**Date:** 2026-02-16  
**Link:** https://leetcode.com/problems/reverse-bits/

## Approach

To solve the problem of reversing the bits of a given 32-bit signed integer, we can follow a systematic approach that leverages bit manipulation techniques. Here's a concise explanation of the solution approach:

### Main Idea:
The goal is to reverse the order of the bits in the 32-bit integer. For example, if the input is `43261596`, its binary representation is `00000010100101000001111010011100`, and the output should be `964176192`, which corresponds to `00111001011110000010100101000000`. 

### Approach:
1. **Bit Manipulation**: We can utilize bitwise operations to extract and place bits in their reversed positions. The idea is to iterate through each bit of the integer, checking if it is set (1) or not (0), and then shifting it to its new position in the reversed integer.

2. **Initialization**: Start with a variable `reversed_num` initialized to 0. This will hold the final reversed integer.

3. **Loop through Bits**: For each of the 32 bits:
   - Use a bitwise AND operation to check the least significant bit of the input number `n`.
   - Shift `reversed_num` left by 1 to make space for the new bit.
   - If the least significant bit of `n` is 1, set the least significant bit of `reversed_num` to 1.
   - Shift `n` right by 1 to process the next bit.

4. **Repeat**: Continue this process for all 32 bits.

5. **Return Result**: After processing all bits, `reversed_num` will contain the reversed bit representation of the input integer.

### Data Structures:
- We primarily use integers for bit manipulation. No additional data structures are needed.

### Complexity:
- **Time Complexity**: O(1) since we are always processing a fixed number of bits (32 bits).
- **Space Complexity**: O(1) as we are using a constant amount of space regardless of the input size.

### Optimization Consideration:
If the function is called multiple times, one potential optimization is to use a lookup table (cache) for previously computed results of common integers or patterns. This would allow for faster retrieval instead of recalculating the bit reversal for the same numbers.

In summary, the solution effectively utilizes bitwise operations to reverse the bits of a 32-bit integer in a straightforward and efficient manner.
