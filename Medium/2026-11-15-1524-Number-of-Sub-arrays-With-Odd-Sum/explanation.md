# Number of Sub-arrays With Odd Sum (Medium)

**Problem ID:** 1524  
**Date:** 2026-11-15  
**Link:** https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/

## Approach

To solve the problem of counting the number of subarrays with an odd sum, we can leverage the properties of prefix sums and the parity (odd/even nature) of these sums.

### Main Idea:
The key observation is that the sum of a subarray is odd if and only if the number of odd integers in that subarray is odd. Therefore, we can track the count of odd and even prefix sums as we iterate through the array. 

### Approach:
1. **Prefix Sum Calculation**: As we iterate through the array, we maintain a running sum (prefix sum) and determine its parity (odd or even).
   - If the prefix sum is even, it means that the sum of elements up to that index is even.
   - If the prefix sum is odd, the sum is odd.

2. **Count Parities**: We maintain two counters:
   - `count_even`: to count how many times we have encountered an even prefix sum.
   - `count_odd`: to count how many times we have encountered an odd prefix sum.

3. **Count Subarrays**:
   - For each element in the array:
     - Update the prefix sum.
     - If the current prefix sum is odd, it can form new subarrays with all previously seen even prefix sums (since odd - even = odd). Thus, add `count_even` to the result.
     - If the current prefix sum is even, it can form new subarrays with all previously seen odd prefix sums (since even - odd = odd). Thus, add `count_odd` to the result.
   - Update the respective counters based on the current prefix sum's parity.

4. **Modulo Operation**: Since the result can be large, we take the result modulo \(10^9 + 7\) at each step to prevent overflow and adhere to the problem constraints.

### Data Structures:
- Two integer counters (`count_even` and `count_odd`) to keep track of the counts of even and odd prefix sums.
- An integer variable to maintain the running prefix sum.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array, as we make a single pass through the array.
- **Space Complexity**: O(1), since we only use a constant amount of additional space for counters and the prefix sum.

This approach efficiently counts the number of subarrays with odd sums by utilizing the properties of prefix sums and their parities, leading to a concise and optimal solution.
