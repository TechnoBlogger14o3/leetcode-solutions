# Find Minimum Operations to Make All Elements Divisible by Three (Easy)

**Problem ID:** 3190  
**Date:** 2025-11-22  
**Link:** https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/

## Approach

To solve the problem of finding the minimum operations to make all elements of an integer array divisible by three, we can break down the approach into a few clear steps:

### Main Idea:
The key insight is to recognize how each number's remainder when divided by 3 (i.e., `num % 3`) determines the number of operations needed to make it divisible by 3. Specifically:
- If `num % 3 == 0`, no operations are needed.
- If `num % 3 == 1`, we can either subtract 1 (1 operation) or add 2 (2 operations).
- If `num % 3 == 2`, we can either subtract 2 (2 operations) or add 1 (1 operation).

### Steps:
1. **Initialize a Counter**: Start with a counter set to zero to keep track of the total operations required.
2. **Iterate through the Array**: For each element in the array, compute its remainder when divided by 3.
3. **Update the Counter**: Based on the remainder:
   - If the remainder is 0, do nothing.
   - If the remainder is 1, add 1 to the counter (for subtraction) or 2 (for addition), but we choose the minimum which is 1.
   - If the remainder is 2, add 1 to the counter (for addition) or 2 (for subtraction), choosing the minimum which is also 1.
4. **Return the Result**: After processing all elements, the counter will hold the minimum number of operations needed.

### Data Structures:
- A simple integer counter is sufficient to keep track of the total operations. No complex data structures are needed due to the straightforward nature of the calculations.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array `nums`. We traverse the array once to compute the operations.
- **Space Complexity**: O(1), as we only use a constant amount of space for the counter, regardless of the input size.

This approach is efficient and straightforward, leveraging modular arithmetic to minimize operations effectively.
