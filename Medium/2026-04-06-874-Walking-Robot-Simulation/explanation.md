# Walking Robot Simulation (Medium)

**Problem ID:** 874  
**Date:** 2026-04-06  
**Link:** https://leetcode.com/problems/walking-robot-simulation/

## Approach

To solve the "Walking Robot Simulation" problem, we can follow a systematic approach that involves simulating the robot's movements based on the commands provided while keeping track of obstacles. Here’s a breakdown of the solution approach:

### Main Idea:
The robot starts at the origin (0, 0) and can turn left or right, as well as move forward by a specified number of units. We need to simulate these movements while checking for obstacles and calculating the maximum squared Euclidean distance from the origin at any point during the simulation.

### Steps to Solve the Problem:
1. **Direction Management**: 
   - Use a list to represent the four possible directions (North, East, South, West) as vectors. This allows us to easily change the robot's direction based on the turn commands (-2 for left, -1 for right).
   - Maintain an index to track the current direction of the robot.

2. **Obstacle Handling**:
   - Store obstacles in a set for O(1) average-time complexity lookups. This allows us to quickly check if the robot's next position is blocked by an obstacle.

3. **Simulation**:
   - Iterate through the commands:
     - For turn commands (-2 and -1), update the direction index accordingly.
     - For move commands (1 to 9), attempt to move the robot forward. For each unit of movement:
       - Calculate the next position based on the current direction.
       - Check if the next position is an obstacle. If it is, stop moving in that direction and proceed to the next command.
       - If the move is valid, update the robot's position and compute the squared distance from the origin. Keep track of the maximum squared distance encountered.

4. **Return Result**:
   - After processing all commands, return the maximum squared distance calculated during the simulation.

### Data Structures:
- **List** for directions: To manage the robot's orientation easily.
- **Set** for obstacles: To allow fast lookups when checking for collisions.
- **Variables** to track the robot's current position and the maximum squared distance.

### Complexity:
- **Time Complexity**: O(N + M), where N is the number of commands and M is the number of obstacles. Each command is processed in constant time, and checking for obstacles is efficient due to the set.
- **Space Complexity**: O(M) for storing the obstacles in a set.

This approach ensures that we efficiently simulate the robot's movements while adhering to the constraints and requirements of the problem, ultimately yielding the correct maximum squared distance from the origin.
