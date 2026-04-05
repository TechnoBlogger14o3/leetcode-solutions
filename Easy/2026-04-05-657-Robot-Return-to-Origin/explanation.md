# Robot Return to Origin (Easy)

**Problem ID:** 657  
**Date:** 2026-04-05  
**Link:** https://leetcode.com/problems/robot-return-to-origin/

## Approach

To solve the "Robot Return to Origin" problem, we can use a straightforward counting approach based on the moves the robot makes. The main idea is to track the net effect of the moves in the vertical and horizontal directions.

### Approach:

1. **Initialization**: Start with two counters, `vertical` and `horizontal`, both initialized to zero. These will represent the net movements in the y-axis and x-axis, respectively.

2. **Iterate through moves**: Loop through each character in the input string `moves`:
   - If the move is 'U' (up), increment the `vertical` counter by 1.
   - If the move is 'D' (down), decrement the `vertical` counter by 1.
   - If the move is 'L' (left), decrement the `horizontal` counter by 1.
   - If the move is 'R' (right), increment the `horizontal` counter by 1.

3. **Check final position**: After processing all moves, check if both `vertical` and `horizontal` counters are zero. If they are, it means the robot has returned to the origin (0, 0), and we return `true`. Otherwise, return `false`.

### Data Structures:
- We only need a few integer variables (`vertical` and `horizontal`), which means the space complexity is O(1).

### Complexity:
- **Time Complexity**: O(n), where n is the length of the `moves` string. We need to iterate through the string once.
- **Space Complexity**: O(1), since we are using a constant amount of space regardless of the input size.

This approach efficiently determines if the robot returns to the origin by simply counting the net movements in each direction, making it optimal for the problem constraints.
