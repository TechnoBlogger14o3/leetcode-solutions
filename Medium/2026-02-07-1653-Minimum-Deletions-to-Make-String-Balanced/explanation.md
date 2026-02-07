# Minimum Deletions to Make String Balanced (Medium)

**Problem ID:** 1653  
**Date:** 2026-02-07  
**Link:** https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/

## Approach

To solve the problem of finding the minimum deletions required to make the string balanced, we need to ensure that all 'a's appear before 'b's in the string. The main idea is to count the number of 'a's and 'b's while traversing the string and determine how many deletions are necessary to achieve the desired order.

### Approach:

1. **Initialization**: Start by initializing two counters: `count_a` to keep track of the number of 'a's encountered so far and `count_b` to count the total number of 'b's in the string.

2. **First Pass**: Traverse the string once to count the total number of 'b's (`count_b`). This will help us understand how many 'b's we have to deal with when processing 'a's.

3. **Second Pass**: Iterate through the string again:
   - For each character:
     - If it is 'a', increment `count_a`.
     - If it is 'b', calculate the number of deletions required if we were to keep all 'a's encountered so far and remove the 'b's that appear after them. This is done by adding `count_b` (the total number of 'b's) to the current deletions and subtracting `count_b` for each 'b' encountered, since we would be removing them.
   - Keep track of the minimum deletions needed at each step.

4. **Result Calculation**: The minimum deletions required will be the least value calculated during the second pass.

### Data Structures:
- Simple integer variables for counting (`count_a`, `count_b`).
- No complex data structures are needed, as we can solve the problem in a single pass after the initial count.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the string. We make two passes through the string: one for counting and one for calculating deletions.
- **Space Complexity**: O(1), as we only use a fixed amount of extra space for counters.

This approach efficiently determines the minimum deletions needed to balance the string by leveraging simple counting and a linear scan, ensuring optimal performance even for the upper limit of input size.
