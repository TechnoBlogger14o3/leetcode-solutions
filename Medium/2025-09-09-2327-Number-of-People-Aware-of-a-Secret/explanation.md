# Number of People Aware of a Secret (Medium)

**Problem ID:** 2327  
**Date:** 2025-09-09  
**Link:** https://leetcode.com/problems/number-of-people-aware-of-a-secret/

## Approach

To solve the problem of determining the number of people who are aware of a secret at the end of day `n`, we can use a simulation approach with an array to track the number of people who discover the secret on each day.

### Approach:

1. **Understanding the Problem**: 
   - On day 1, one person knows the secret. Each person shares the secret after a specified `delay` and forgets it after a specified `forget` period.
   - We need to keep track of how many new people learn the secret each day, considering the constraints of `delay` and `forget`.

2. **Data Structures**:
   - Use an array `dp` where `dp[i]` represents the number of people who discover the secret on day `i`.
   - Initialize `dp[1]` to 1, since one person knows the secret on day 1.

3. **Simulation**:
   - Iterate through each day from 2 to `n`.
   - For each day `i`, calculate the number of new people who can learn the secret:
     - A person who discovers the secret on day `j` (where `j` ranges from `i - delay` to `i - forget + 1`) can share the secret on day `i`.
     - The number of new people who learn the secret on day `i` is the sum of `dp[j]` for all valid `j`.
   - Update `dp[i]` with the calculated number of new people.

4. **Summation**:
   - To get the total number of people who know the secret by the end of day `n`, sum all values in the `dp` array from day 1 to day `n`.

5. **Modulo Operation**:
   - Since the result can be large, apply modulo \(10^9 + 7\) to each update and the final result to prevent overflow.

### Complexity:
- **Time Complexity**: O(n^2) in the worst case, as for each day, we may sum values from multiple previous days.
- **Space Complexity**: O(n) for the `dp` array.

This approach effectively simulates the process of sharing and forgetting the secret day by day, allowing us to compute the total number of people aware of the secret by the end of day `n`.
