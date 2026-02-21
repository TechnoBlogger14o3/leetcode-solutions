# Prime Number of Set Bits in Binary Representation (Easy)

**Problem ID:** 762  
**Date:** 2026-02-21  
**Link:** https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/

## Approach

To solve the problem of counting numbers in the inclusive range \([left, right]\) that have a prime number of set bits in their binary representation, we can follow these steps:

### Main Idea:
1. **Count Set Bits**: For each number in the range, determine the number of set bits (1's) in its binary representation.
2. **Check for Primality**: For the count of set bits obtained, check if that number is prime.
3. **Count Valid Numbers**: Maintain a count of how many numbers have a prime number of set bits.

### Steps:
1. **Precompute Prime Numbers**:
   - Since the maximum number of set bits for any number in the range \([1, 10^6]\) is 20 (as \(10^6\) in binary is `111101101101011001000000`), we can precompute the primality for numbers up to 20 using a simple sieve method or a prime-checking function. This allows us to quickly check if a count of set bits is prime.

2. **Iterate Through the Range**:
   - Loop through each integer \(n\) from \(left\) to \(right\).
   - For each \(n\), calculate the number of set bits using Python's built-in function `bin(n).count('1')` or equivalent methods.

3. **Check Primality and Count**:
   - For the count of set bits, check if it is in our precomputed list of prime numbers.
   - If it is prime, increment a counter.

### Data Structures:
- A boolean array or set to store the prime status of numbers from 0 to 20.
- A simple integer counter to keep track of how many valid numbers we find.

### Complexity:
- **Time Complexity**: The solution will run in \(O(n \cdot k)\) where \(n\) is the number of integers in the range \([left, right]\) (at most \(10^4\)), and \(k\) is a constant representing the maximum number of bits (which is 20). Thus, the overall complexity is effectively \(O(n)\).
- **Space Complexity**: The space used for the prime check is \(O(1)\) since it only stores information for numbers up to 20.

By following this approach, we efficiently count the numbers with a prime number of set bits in the specified range.
