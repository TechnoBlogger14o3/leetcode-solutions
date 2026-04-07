# Walking Robot Simulation II (Medium)

**Problem ID:** 2069  
**Date:** 2026-04-07  
**Link:** https://leetcode.com/problems/walking-robot-simulation-ii/

## Approach

To solve the "Walking Robot Simulation II" problem, we will implement a `Robot` class that simulates the movement of a robot on a grid defined by its width and height. The main idea revolves around managing the robot's position and direction while handling boundary conditions effectively.

### Approach:

1. **Initialization**:
   - The robot starts at position `(0, 0)` and faces "East". We will use an array to represent the directions: `["East", "North", "West", "South"]`, corresponding to indices 0, 1, 2, and 3 respectively.
   - We will also maintain the robot's current position as `(x, y)` and an index for the current direction.

2. **Movement Logic**:
   - The robot can move in the direction it is facing by updating its position based on the current direction.
   - If the robot attempts to move out of bounds, it will turn 90 degrees counterclockwise (which can be achieved by decrementing the direction index) and attempt to move again in the new direction.

3. **Handling Steps**:
   - The `step` method will take an integer `num` representing the number of steps to move. For each step:
     - Calculate the potential new position based on the current direction.
     - If the new position is valid (within bounds), update the position. If it is out of bounds, turn and retry until all steps are processed.
   - This involves a loop that continues until all steps are executed or the robot has turned in all four directions without moving.

4. **Retrieving Position and Direction**:
   - The `getPos` method will return the current coordinates as an array `[x, y]`.
   - The `getDir` method will return the current direction as a string based on the direction index.

### Data Structures:
- An integer array for the robot's position `(x, y)`.
- An integer to track the direction index.
- A string array for the directions.

### Complexity:
- **Time Complexity**: The `step` method can take up to `O(num)` time in the worst case, where the robot turns multiple times without moving. However, the total number of operations across all calls to `step` is limited by the constraints, making it efficient overall.
- **Space Complexity**: The space used is constant `O(1)` since we only maintain a few variables for position and direction, regardless of the number of steps.

This approach efficiently simulates the robot's movement while adhering to the constraints and requirements of the problem.
