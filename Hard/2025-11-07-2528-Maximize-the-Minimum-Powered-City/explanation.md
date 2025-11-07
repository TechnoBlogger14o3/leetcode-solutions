# Maximize the Minimum Powered City (Hard)

**Problem ID:** 2528  
**Date:** 2025-11-07  
**Link:** https://leetcode.com/problems/maximize-the-minimum-powered-city/

## Approach

To solve the problem "Maximize the Minimum Powered City," we can use a binary search approach combined with a greedy strategy to determine the optimal placement of power stations. Here's a concise breakdown of the approach:

### Problem Understanding
We need to maximize the minimum power of any city after potentially adding `k` new power stations across the cities. Each city has a certain number of existing power stations, and each power station can supply power to cities within a specified range `r`.

### Approach
1. **Binary Search Setup**: 
   - We will perform a binary search on the possible values of the minimum power, ranging from `0` (the lowest possible power) to `max(stations) + k` (the highest possible power if all `k` stations are added to the city with the maximum existing stations).
   - The goal is to find the highest value of minimum power that can be achieved.

2. **Feasibility Check**:
   - For each candidate power `mid` during the binary search, we need to check if it is feasible to achieve at least `mid` power in every city using the existing and additional power stations.
   - This can be done using a greedy strategy:
     - Maintain a running sum of power contributions from existing power stations using a sliding window technique.
     - For each city, calculate how many additional power stations are needed to ensure its power reaches at least `mid`.
     - If the total number of additional stations needed exceeds `k`, then `mid` is not feasible.

3. **Data Structures**:
   - An array to keep track of the cumulative power contributions from existing stations.
   - A variable to count the number of additional power stations needed while iterating through the cities.

### Complexity
- **Time Complexity**: The binary search runs in `O(log(max(stations) + k))`, and for each mid value, the feasibility check runs in `O(n)`, leading to an overall complexity of `O(n log(max(stations) + k))`.
- **Space Complexity**: The space complexity is `O(n)` due to the cumulative power array used for the feasibility check.

### Conclusion
By combining binary search with a greedy approach, we can efficiently determine the maximum possible minimum power of a city after optimally placing the additional power stations. This method ensures that we explore all potential outcomes while maintaining a manageable computational complexity.
