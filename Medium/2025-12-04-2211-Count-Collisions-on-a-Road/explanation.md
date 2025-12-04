# Count Collisions on a Road (Medium)

**Problem ID:** 2211  
**Date:** 2025-12-04  
**Link:** https://leetcode.com/problems/count-collisions-on-a-road/

## Approach

To solve the problem of counting collisions on a road with cars moving in different directions, we can use a straightforward linear traversal approach. The main idea is to iterate through the string of directions and keep track of the collisions based on the rules provided.

### Approach:

1. **Initialization**: Start with a collision counter set to zero.

2. **Iterate through the string**: Loop through each character in the `directions` string:
   - If you encounter a 'R' (car moving right), check the next character:
     - If it's 'L' (car moving left), a collision occurs, contributing 2 to the collision count. Both cars will stop moving after this collision.
     - If it's 'S' (stationary car), a collision occurs, contributing 1 to the collision count.
   - If you encounter an 'L', simply continue as it won't cause any additional collisions unless followed by 'R'.
   - If you encounter 'S', check the previous character:
     - If it's 'R', it has already been counted in the previous step.
     - If it's 'L', it will also not contribute to any new collisions.

3. **Handle stationary cars**: When a stationary car ('S') is encountered, it can only collide with cars moving towards it (i.e., 'R' before it or 'L' after it). Thus, ensure that collisions are counted correctly based on the previous and next characters.

### Data Structures:
- A simple integer counter to keep track of the total number of collisions is sufficient. No additional data structures are required since we are processing the string in a single pass.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the `directions` string, as we make a single pass through the string.
- **Space Complexity**: O(1), since we are using a constant amount of space for the collision counter.

This approach is efficient and directly addresses the problem requirements by leveraging the properties of the string and the rules of collision counting.
