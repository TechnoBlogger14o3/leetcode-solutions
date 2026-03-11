# Complement of Base 10 Integer (Easy)

**Problem ID:** 1009  
**Date:** 2026-03-11  
**Link:** https://leetcode.com/problems/complement-of-base-10-integer/

## Approach

To solve the problem of finding the complement of a base 10 integer, we can follow a straightforward approach based on binary representation.

### Main Idea:
The complement of an integer in binary is obtained by flipping all its bits: converting all `0`s to `1`s and all `1`s to `0`s. To compute the complement, we need to determine the binary representation of the integer, identify the number of bits, and then create a mask that will allow us to flip the bits.

### Steps:
1. **Identify the Bit Length**: Determine the number of bits required to represent the integer `n` in binary. This can be done using the `bit_length()` method, which gives the number of bits necessary to represent the integer in binary, excluding the sign bit.

2. **Create a Mask**: Construct a mask that has all bits set to `1` for the length of the binary representation of `n`. This can be achieved using the expression `(1 << bit_length) - 1`. This expression shifts `1` left by `bit_length` positions, resulting in a number with a `1` followed by `bit_length` zeros, and subtracting `1` converts all those zeros to `1`s.

3. **Compute the Complement**: The complement can then be calculated by performing a bitwise XOR operation between `n` and the mask. This operation will flip all bits of `n` as required.

### Data Structures:
- No complex data structures are required; basic integer operations and bitwise manipulation are sufficient.

### Complexity:
- **Time Complexity**: O(1), as the operations performed (bit length calculation, bitwise operations) do not depend on the size of `n`.
- **Space Complexity**: O(1), since we are only using a fixed amount of space for variables.

By following this approach, we can efficiently compute the complement of any integer within the given constraints.
