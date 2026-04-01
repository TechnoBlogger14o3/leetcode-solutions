# Robot Collisions (Hard)

**Problem ID:** 2751  
**Date:** 2026-04-01  
**Link:** https://leetcode.com/problems/robot-collisions/

## Approach

To solve the "Robot Collisions" problem, we can utilize a stack-based approach to efficiently manage the interactions between robots as they move along a line.

### Main Idea
The key insight is to recognize that collisions only occur between robots moving towards each other: specifically, a robot moving right ('R') can collide with a robot moving left ('L'). Therefore, we can process the robots in the order of their positions, maintaining a stack to keep track of the surviving robots as we simulate their movements and collisions.

### Approach
1. **Sort Robots by Position**: First, we need to pair each robot's position, health, and direction, and then sort these pairs based on their positions. This allows us to process robots in the order they appear on the line.

2. **Use a Stack for Collision Management**: We will use a stack to keep track of the robots that are still active:
   - If a robot is moving to the right ('R'), we simply push it onto the stack.
   - If a robot is moving to the left ('L'):
     - We check the top of the stack (the last robot that moved to the right):
       - If the stack is empty, the left-moving robot survives.
       - If the top robot is moving right, a collision occurs. We compare their healths:
         - If the left-moving robot has higher health, it survives, and the right-moving robot's health decreases by 1.
         - If the right-moving robot has higher health, it survives, and the left-moving robot is discarded.
         - If both have equal health, both are discarded.
     - Continue this process until no more collisions can occur or the stack is empty.

3. **Final Result Extraction**: After processing all robots, the stack will contain the surviving robots in the order they were originally input. We can extract their health values and return them as the result.

### Data Structures
- **Stack**: To manage the active robots and handle collisions efficiently.
- **Array/List**: To store the initial robot attributes (positions, healths, directions) and to generate the final output.

### Complexity
- **Time Complexity**: O(n log n) due to the initial sorting of the robots by position. The subsequent processing of the robots using the stack is O(n) in the worst case, leading to an overall complexity of O(n log n).
- **Space Complexity**: O(n) for storing the stack and the sorted list of robots.

This approach efficiently simulates the robot movements and resolves collisions while maintaining the order of surviving robots, ensuring that we meet the problem's requirements within the given constraints.
