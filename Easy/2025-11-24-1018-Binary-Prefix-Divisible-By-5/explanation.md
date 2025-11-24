# Binary Prefix Divisible By 5 (Easy)

**Problem ID:** 1018  
**Date:** 2025-11-24  
**Link:** https://leetcode.com/problems/binary-prefix-divisible-by-5/

## Approach

To solve the problem of determining whether the binary prefixes of a given binary array are divisible by 5, we can adopt an efficient approach that avoids constructing large integers directly from binary representations.

### Approach:

1. **Understanding Binary Representation**: Each prefix can be interpreted as a binary number. For instance, the binary number represented by the array `nums[0..i]` can be computed incrementally. Instead of converting the entire prefix to a decimal number at each step, we can maintain a running total.

2. **Incremental Calculation**: As we iterate through the array, we can maintain a variable `current` that represents the decimal value of the binary number formed by the prefix `nums[0..i]`. We update this variable using the formula:
   \[
   \text{current} = (\text{current} \times 2 + \text{nums}[i]) \mod 5
   \]
   This allows us to keep track of the value modulo 5, which is sufficient for our divisibility check.

3. **Divisibility Check**: For each prefix, after updating `current`, we check if `current` is equal to 0. If it is, it means the binary number represented by the prefix is divisible by 5, and we append `true` to our result array; otherwise, we append `false`.

4. **Data Structures**: We will use a simple list to store the boolean results for each prefix.

5. **Complexity**: The time complexity of this approach is O(n), where n is the length of the input array `nums`, since we make a single pass through the array. The space complexity is O(n) for the output array.

### Summary:
By leveraging the properties of binary numbers and modular arithmetic, we can efficiently determine the divisibility of binary prefixes by 5 without constructing large integers. This results in a straightforward and optimal solution to the problem.
