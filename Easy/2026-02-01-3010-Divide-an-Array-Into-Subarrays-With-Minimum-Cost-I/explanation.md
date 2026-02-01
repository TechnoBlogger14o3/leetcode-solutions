# Divide an Array Into Subarrays With Minimum Cost I (Easy)

**Problem ID:** 3010  
**Date:** 2026-02-01  
**Link:** https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/

## Approach

To solve the problem of dividing an array into three disjoint contiguous subarrays with the minimum possible sum of their costs, we can utilize a dynamic programming approach. Here's a concise explanation of the solution:

### Main Idea:
The goal is to partition the given array `nums` into exactly three subarrays such that the sum of the first elements of these subarrays (their costs) is minimized. The cost of each subarray is defined as the value of its first element.

### Approach:
1. **Dynamic Programming Table**: We will maintain a 2D DP table `dp[i][j]` where `i` represents the index in the array `nums` and `j` represents the number of subarrays formed up to that index. The value stored in `dp[i][j]` will be the minimum cost of forming `j` subarrays using the first `i` elements of `nums`.

2. **Initialization**: Start by initializing the DP table. For `j = 1`, the cost is simply the first element of the array up to index `i`, which means `dp[i][1] = nums[0]` for all valid `i`.

3. **Filling the DP Table**:
   - For each `j` from 2 to 3 (since we need exactly three subarrays), iterate through possible end indices `i` for the last subarray.
   - For each possible end index `i`, iterate through all possible starting points `k` for the last subarray. The cost of the last subarray will be `nums[k]`, and we can add this to the minimum cost of forming `j-1` subarrays from the first `k-1` elements.
   - Update `dp[i][j]` as the minimum of its current value and the cost computed from the previous subarrays.

4. **Final Result**: The answer will be found in `dp[n-1][3]`, where `n` is the length of the input array, representing the minimum cost to form three subarrays using all elements.

### Data Structures:
- A 2D list (or array) for the DP table, where `dp[i][j]` holds the minimum cost for forming `j` subarrays using the first `i` elements of `nums`.

### Complexity:
- **Time Complexity**: The approach runs in \(O(n^2)\) because for each of the three subarrays, we iterate over possible end indices and possible starting points for the last subarray.
- **Space Complexity**: The space complexity is \(O(n)\) for the DP table since we only need to store results for the current and previous subarray counts.

This structured approach ensures that we efficiently compute the minimum cost of dividing the array into three contiguous subarrays while adhering to the constraints provided.
