# Smallest Integer Divisible by K (Medium)

**Problem ID:** 1015  
**Date:** 2025-11-25  
**Link:** https://leetcode.com/problems/smallest-integer-divisible-by-k/

## Approach

To solve the problem of finding the length of the smallest positive integer \( n \) that consists solely of the digit '1' and is divisible by a given integer \( k \), we can utilize a breadth-first search (BFS) approach to explore potential candidates for \( n \).

### Approach:

1. **Understanding the Problem**: 
   - The number \( n \) can be represented as a sequence of '1's: \( 1, 11, 111, \ldots \). The goal is to find the smallest such number that is divisible by \( k \).

2. **Using Modulo for Divisibility**:
   - Instead of generating large numbers directly, we can work with their remainders when divided by \( k \). This is because if \( n \equiv 0 \mod k \), then \( n \) is divisible by \( k \).

3. **BFS for Exploration**:
   - We can treat each number formed by '1's as a node in a graph. Starting from the number '1', we can generate new numbers by appending another '1' to the current number.
   - For each number represented by its remainder \( r \) (where \( r = n \mod k \)), we can generate two new remainders:
     - \( (r \times 10 + 1) \mod k \) (this represents appending another '1').
   - We will keep track of the length of the number (or the number of '1's) in the BFS queue.

4. **Cycle Prevention**:
   - To avoid processing the same remainder multiple times, we maintain a set of visited remainders.

5. **Termination**:
   - The BFS continues until we either find a remainder of \( 0 \) (indicating divisibility by \( k \)) or exhaust all possibilities without finding such a remainder.

### Data Structures:
- A queue to facilitate the BFS process.
- A set to track visited remainders to prevent cycles.

### Time Complexity:
- The time complexity is \( O(k) \) since there are at most \( k \) different remainders (from \( 0 \) to \( k-1 \)) that we can encounter.

### Space Complexity:
- The space complexity is also \( O(k) \) due to the storage of visited remainders.

### Conclusion:
By using BFS and focusing on remainders rather than constructing large numbers, we efficiently find the length of the smallest integer composed solely of '1's that is divisible by \( k \). If no such integer exists, we return -1.
