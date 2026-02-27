# Minimum Operations to Equalize Binary String (Hard)

**Problem ID:** 3666  
**Date:** 2026-02-27  
**Link:** https://leetcode.com/problems/minimum-operations-to-equalize-binary-string/

## Approach

To solve the problem of determining the minimum number of operations required to make all characters in a binary string equal to '1', we can follow a structured approach:

### Main Idea
The key insight is to focus on the number of '0's in the string, as these are the characters we need to flip to achieve our goal. Each operation allows us to flip exactly `k` indices, and thus we need to find how many operations are necessary to flip all '0's to '1's.

### Steps to Approach the Problem

1. **Count the '0's**: First, traverse the string to count the total number of '0's, denoted as `count_0`.

2. **Check Feasibility**: If `count_0` is less than `k`, it is impossible to perform a valid operation (since we cannot choose `k` indices), and we should return -1 immediately.

3. **Calculate Operations**: If `count_0` is greater than zero, we need to determine how many operations are required:
   - Each operation can flip `k` indices. Therefore, the minimum number of operations required to flip all '0's can be calculated as:
     \[
     \text{operations} = \lceil \frac{\text{count\_0}}{k} \rceil
     \]
   - This can be computed using integer arithmetic as:
     \[
     \text{operations} = \frac{\text{count\_0} + k - 1}{k}
     \]
   - This formula ensures that we round up when `count_0` is not a perfect multiple of `k`.

### Data Structures
- A simple integer variable to keep track of `count_0` is sufficient. No complex data structures are needed since we are only counting characters.

### Complexity
- **Time Complexity**: O(n), where n is the length of the string. We need to traverse the string once to count the '0's.
- **Space Complexity**: O(1), as we are using a constant amount of space for counting.

### Conclusion
By counting the '0's and determining if we can feasibly flip them with the given `k`, we can efficiently compute the minimum number of operations needed to convert the string into all '1's. If it's not possible to perform the required flips, we return -1.
