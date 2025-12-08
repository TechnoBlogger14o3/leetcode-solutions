# Count Square Sum Triples (Easy)

**Problem ID:** 1925  
**Date:** 2025-12-08  
**Link:** https://leetcode.com/problems/count-square-sum-triples/

## Approach

To solve the problem of counting square sum triples (a, b, c) such that \( a^2 + b^2 = c^2 \) with the constraints \( 1 \leq a, b, c \leq n \), we can follow a systematic approach:

### Main Idea
The core idea is to identify all valid triples (a, b, c) that satisfy the Pythagorean theorem within the given range. We can achieve this by iterating through possible values of c and checking for pairs (a, b) that fulfill the equation.

### Steps
1. **Iterate Over c**: Loop through all integers from 1 to n for the variable c.
2. **Calculate c²**: For each c, compute \( c^2 \).
3. **Find Pairs (a, b)**: For each possible integer a from 1 to c (since a and b can be at most c), calculate \( b^2 \) as \( c^2 - a^2 \).
4. **Check Validity**: If \( b^2 \) is a perfect square, and \( b \) (which is the square root of \( b^2 \)) is also less than or equal to n, then we have found a valid pair (a, b).
5. **Count Unique Triples**: Since the order of (a, b) matters, count both (a, b, c) and (b, a, c) if a ≠ b.

### Data Structures
- **Integer Variables**: To store the values of a, b, and c.
- **Counter**: An integer to keep track of the number of valid triples found.

### Complexity
- **Time Complexity**: The outer loop runs n times (for c), and the inner loop runs at most c times (for a). Thus, the overall complexity is approximately \( O(n^2) \), which is efficient given the constraint \( n \leq 250 \).
- **Space Complexity**: O(1) since we are only using a fixed number of variables for counting and calculations.

### Conclusion
This approach efficiently counts the valid square sum triples by leveraging the properties of Pythagorean triples and iterating through potential values systematically. The method ensures that we do not miss any combinations and adheres to the constraints provided.
