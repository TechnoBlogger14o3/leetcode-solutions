# Maximum Number of Operations to Move Ones to the End (Medium)

**Problem ID:** 3228  
**Date:** 2025-11-13  
**Link:** https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/

## Approach

To solve the problem of maximizing the number of operations to move '1's to the end of a binary string, we can adopt a systematic approach:

### Problem Understanding
The goal is to count how many times we can move a '1' to the right until it reaches either the end of the string or another '1'. Each operation can only be performed when a '1' is immediately followed by a '0'.

### Approach
1. **Identify Pairs of '1's and '0's**: As we traverse the string, we need to keep track of the number of '1's that can potentially be moved. For each '1' encountered, we check how many '0's follow it until we hit another '1' or reach the end of the string.

2. **Count Movable '1's**: For each '1' found, count how many '0's are between it and the next '1'. The number of operations possible for that specific '1' is equal to the number of '0's encountered before the next '1'.

3. **Iterate Through the String**: We can maintain two counters:
   - `count_ones`: To keep track of the number of '1's encountered so far.
   - `count_operations`: To accumulate the total number of operations possible.

4. **Calculate Operations**: For each '1' found, add the current count of '0's (which can be moved) to `count_operations`. After processing a '0', if we encounter another '1', we reset the count of '0's since we can no longer move the previous '1' past this new '1'.

5. **Final Count**: The result will be stored in `count_operations`, which will represent the maximum number of operations performed.

### Data Structures
- We primarily use simple integer counters (`count_ones`, `count_operations`, and `count_zeros`) as we traverse the string. No complex data structures are needed, making this approach efficient.

### Complexity
- **Time Complexity**: O(n), where n is the length of the string. We make a single pass through the string.
- **Space Complexity**: O(1), as we are only using a fixed number of integer variables for counting.

By following this approach, we efficiently determine the maximum number of operations to move '1's to the end of the string while adhering to the problem's constraints.
