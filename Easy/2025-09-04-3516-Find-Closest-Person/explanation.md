# Find Closest Person (Easy)

**Problem ID:** 3516  
**Date:** 2025-09-04  
**Link:** https://leetcode.com/problems/find-closest-person/

## Approach

To solve the problem of determining which person reaches Person 3 first on a number line, we can break down the solution into a few clear steps:

### Main Idea:
The core idea is to calculate the distance each person (Person 1 and Person 2) needs to travel to reach Person 3 and then compare these distances. The person with the shorter distance will reach Person 3 first.

### Steps:
1. **Calculate Distances**:
   - Compute the absolute distance from Person 1 (position `x`) to Person 3 (position `z`): `distance1 = |x - z|`.
   - Compute the absolute distance from Person 2 (position `y`) to Person 3 (position `z`): `distance2 = |y - z|`.

2. **Compare Distances**:
   - If `distance1` is less than `distance2`, return `1` (Person 1 arrives first).
   - If `distance1` is greater than `distance2`, return `2` (Person 2 arrives first).
   - If both distances are equal, return `0` (both arrive at the same time).

### Data Structures:
This problem does not require any complex data structures. Simple integer variables are sufficient to store the positions and distances.

### Complexity:
- **Time Complexity**: O(1), as we perform a constant number of operations regardless of input size.
- **Space Complexity**: O(1), since we only use a fixed amount of space to store the distances and results.

This approach is efficient and straightforward, leveraging basic arithmetic operations to arrive at the solution.
