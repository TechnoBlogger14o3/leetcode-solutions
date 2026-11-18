# Minimum Number of Changes to Make Binary String Beautiful (Medium)

**Problem ID:** 2914  
**Date:** 2026-11-18  
**Link:** https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/

## Approach

To solve the problem of making a binary string beautiful, we need to ensure that the string can be partitioned into even-length substrings, each containing only '0's or only '1's. The approach involves the following steps:

### Problem Breakdown
1. **Identify Segments**: Traverse the string to identify segments of consecutive identical characters ('0's or '1's). Each segment will have a length that can be either even or odd.

2. **Count Changes**: For each segment, if the length is odd, we need to change one character to make it even. The goal is to minimize the number of changes across all segments.

3. **Calculate Minimum Changes**: As we iterate through the string:
   - Count the number of segments.
   - For each segment, if its length is odd, increment a counter for changes needed.

### Steps to Implement the Approach
- Initialize a counter for the number of changes required.
- Loop through the string while maintaining a count of consecutive characters.
- Whenever the character changes, check the length of the previous segment:
  - If it's odd, increment the changes counter.
- After the loop, check the last segment as well.
- The final value of the changes counter will be the minimum number of changes required to make the string beautiful.

### Data Structures
- A simple integer counter for changes.
- No complex data structures are required since we only need to keep track of the current character and its count.

### Time Complexity
The time complexity of this approach is O(n), where n is the length of the string. This is efficient given the constraints (up to 100,000 characters), as we only make a single pass through the string.

### Space Complexity
The space complexity is O(1) since we are using a fixed amount of extra space regardless of the input size.

In summary, the solution involves counting segments of consecutive characters and adjusting for any odd-length segments to ensure that all segments can be made even, leading to the minimum number of changes required to achieve a beautiful binary string.
