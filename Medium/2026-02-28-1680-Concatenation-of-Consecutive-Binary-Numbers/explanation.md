# Concatenation of Consecutive Binary Numbers (Medium)

**Problem ID:** 1680  
**Date:** 2026-02-28  
**Link:** https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/

## Approach

To solve the problem of concatenating the binary representations of integers from 1 to n and returning the result modulo \(10^9 + 7\), we can follow a systematic approach:

### Problem Breakdown
1. **Binary Representation**: Each integer from 1 to n can be converted to its binary form. For example, the binary representation of 1 is "1", of 2 is "10", and of 3 is "11".

2. **Concatenation**: We need to concatenate these binary strings together to form a single binary string. For instance, for n = 3, the concatenated binary string is "11011".

3. **Decimal Conversion**: After forming the concatenated binary string, we need to convert it back to its decimal representation.

4. **Modulo Operation**: Since the resulting number can be very large, we will take the result modulo \(10^9 + 7\) to keep it manageable.

### Approach
1. **Iterate through Numbers**: We will loop through each integer from 1 to n.
  
2. **Binary Length Calculation**: For each integer i, determine the number of bits in its binary representation. This can be done using the formula `floor(log2(i)) + 1`, or simply using `i.bit_length()` in Python.

3. **Shift and Add**: Instead of constructing a large binary string, we can maintain an integer `result` that will hold the decimal value of the concatenated binary number:
   - For each integer i, left-shift the current `result` by the number of bits in i (which is equivalent to multiplying by \(2^{\text{number of bits}}\)).
   - Then, add the integer i to the `result`.
   - Apply modulo \(10^9 + 7\) at each step to prevent overflow.

4. **Final Result**: After processing all integers from 1 to n, the `result` will contain the desired value.

### Data Structures
- **Integer**: We primarily use an integer to store the cumulative result, which will be updated iteratively.

### Complexity
- **Time Complexity**: The approach runs in O(n) time, as we perform a constant amount of work for each integer from 1 to n.
- **Space Complexity**: O(1), since we only use a fixed amount of extra space for the result and do not store the binary strings.

### Summary
The main idea is to avoid constructing large binary strings by directly manipulating an integer that represents the concatenated binary value. This efficient approach leverages bit manipulation to achieve the desired result while managing large numbers with modular arithmetic.
