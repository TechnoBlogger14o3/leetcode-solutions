# Check if Binary String Has at Most One Segment of Ones (Easy)

**Problem ID:** 1784  
**Date:** 2026-03-06  
**Link:** https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/

## Approach

To solve the problem of checking if a binary string has at most one contiguous segment of ones, we can adopt a straightforward approach that involves scanning the string for segments of '1's and '0's.

### Approach:

1. **Initialization**: Start by defining a variable to track the number of segments of '1's encountered. Initialize this counter to zero.

2. **Iterate through the string**: Loop through each character in the binary string:
   - Whenever you encounter a '1', check if this is the beginning of a new segment of '1's. This can be determined by checking if the previous character was '0' or if it is the first character of the string.
   - If it is indeed the start of a new segment, increment the counter for segments of '1's.

3. **Check the counter**: After finishing the iteration, check the value of the segment counter:
   - If the counter is greater than 1, return `false`, indicating that there are multiple segments of '1's.
   - If the counter is 0 or 1, return `true`, indicating at most one segment of '1's exists.

### Key Considerations:

- **Data Structures**: The solution primarily uses a simple integer counter to track segments and does not require any complex data structures.
- **Complexity**: The time complexity of this approach is O(n), where n is the length of the binary string, as we make a single pass through the string. The space complexity is O(1), since we are using a constant amount of additional space.

This method efficiently checks for the required condition by leveraging a single traversal of the string, making it optimal for the problem constraints.
