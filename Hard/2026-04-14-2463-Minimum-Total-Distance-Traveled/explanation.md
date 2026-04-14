# Minimum Total Distance Traveled (Hard)

**Problem ID:** 2463  
**Date:** 2026-04-14  
**Link:** https://leetcode.com/problems/minimum-total-distance-traveled/

## Approach

To solve the problem of minimizing the total distance traveled by robots to reach factories, we can employ a dynamic programming approach. Here’s a concise breakdown of the solution strategy:

### Problem Breakdown
1. **Understanding Movement**: Robots can move towards factories, and each factory has a limit on how many robots it can repair. The goal is to minimize the total distance traveled by all robots to the factories.

2. **Sorting**: Start by sorting the `robot` positions and the `factory` positions. This helps in efficiently matching robots to factories based on proximity.

3. **Dynamic Programming Table**: Define a DP table `dp[i][j]` where:
   - `i` represents the first `i` factories considered.
   - `j` represents the first `j` robots considered.
   - `dp[i][j]` holds the minimum distance required to repair the first `j` robots using the first `i` factories.

4. **Transition Logic**: For each factory `i`, determine how many robots can be serviced from it. Iterate over the possible number of robots `k` that can be repaired by factory `i` (up to its limit or the remaining robots). For each valid `k`, calculate the distance for these `k` robots and update the DP table:
   \[
   dp[i][j] = \min(dp[i][j], dp[i-1][j-k] + \text{distance for k robots from factory i})
   \]
   The distance for `k` robots is computed based on their positions and the factory's position.

5. **Base Cases**: Initialize the DP table such that `dp[0][0] = 0` (zero distance for zero robots) and set other entries to infinity or a large number as appropriate.

6. **Final Result**: The answer will be found in `dp[num_factories][num_robots]`, which gives the minimum distance to repair all robots using all factories.

### Data Structures
- **Arrays**: Use arrays to store robot positions, factory positions, and the DP table.
- **Sorting**: Sorting the robots and factories is crucial for efficient matching.

### Complexity
- **Time Complexity**: The approach runs in \(O(n \cdot m \cdot k)\), where \(n\) is the number of factories, \(m\) is the number of robots, and \(k\) is the maximum limit of robots that any factory can repair. Given the constraints, this is efficient.
- **Space Complexity**: The space complexity is \(O(n \cdot m)\) due to the DP table.

This structured approach ensures that we systematically explore all possible ways to assign robots to factories while keeping track of the minimum distances, ultimately leading to an optimal solution.
