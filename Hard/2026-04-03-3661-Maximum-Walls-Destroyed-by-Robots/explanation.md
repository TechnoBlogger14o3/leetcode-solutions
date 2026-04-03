# Maximum Walls Destroyed by Robots (Hard)

**Problem ID:** 3661  
**Date:** 2026-04-03  
**Link:** https://leetcode.com/problems/maximum-walls-destroyed-by-robots/

## Approach

To solve the problem of determining the maximum number of unique walls that can be destroyed by robots, we can adopt a systematic approach that involves sorting and a two-pointer technique.

### Main Idea:
The core idea is to simulate the firing of bullets from each robot in both left and right directions, while keeping track of the walls that can be destroyed. We need to ensure that we account for the distance each robot can shoot and the presence of other robots that may block the bullets.

### Steps:
1. **Data Preparation**:
   - Combine the `robots` and `distance` arrays into a list of tuples, where each tuple contains the robot's position and its maximum firing distance.
   - Sort this list based on robot positions to facilitate the simulation of bullet firing.

2. **Simulate Bullet Firing**:
   - For each robot, calculate the effective range of its bullet in both directions:
     - **Left**: From `robot_position - distance` to `robot_position`.
     - **Right**: From `robot_position` to `robot_position + distance`.
   - Use a set to keep track of unique walls that can be destroyed.

3. **Check for Walls**:
   - For the left firing direction, iterate from the leftmost wall within the effective range up to the robot's position. If a wall is found, add it to the set of destroyed walls unless blocked by another robot.
   - For the right firing direction, similarly check from the robot's position to the rightmost wall within the effective range.

4. **Handle Blockages**:
   - While checking for walls, if a robot is encountered within the effective range (either left or right), stop the firing simulation in that direction to prevent further wall destruction.

5. **Count Unique Walls**:
   - After processing all robots, the size of the set containing destroyed walls will give the maximum number of unique walls destroyed.

### Data Structures:
- A list of tuples for robots and their distances.
- A set to store unique wall positions that have been destroyed.

### Complexity:
- Sorting the robots takes \(O(n \log n)\), where \(n\) is the number of robots.
- The wall checking process involves iterating through the walls, which can be done in \(O(m)\), where \(m\) is the number of walls. 
- Thus, the overall time complexity is \(O(n \log n + m)\), which is efficient given the constraints.

This approach ensures that we efficiently track the walls that can be destroyed while considering the limitations imposed by the positions of the robots.
