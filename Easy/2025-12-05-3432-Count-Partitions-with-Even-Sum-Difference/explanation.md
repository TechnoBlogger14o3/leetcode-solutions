# Count Partitions with Even Sum Difference (Easy)

**Problem ID:** 3432  
**Date:** 2025-12-05  
**Link:** https://leetcode.com/problems/count-partitions-with-even-sum-difference/

## Approach

To solve the problem of counting partitions with an even sum difference, we can leverage the properties of even and odd numbers. The key insight is that the difference between the sums of the left and right subarrays will be even if both sums are either even or odd.

### Approach:

1. **Calculate the Total Sum**: First, compute the total sum of the array. This will help us determine the parity (even or odd) of the sums of the left and right subarrays.

2. **Iterate Through Possible Partitions**: We will iterate through the array to consider each possible partition index `i`, which splits the array into two parts:
   - Left subarray: `nums[0]` to `nums[i]`
   - Right subarray: `nums[i+1]` to `nums[n-1]`

3. **Track Sums and Parity**: Maintain a running sum for the left subarray as we iterate. For each partition index `i`, calculate the sum of the left subarray and derive the sum of the right subarray using the total sum:
   - Left sum = sum of elements from `0` to `i`
   - Right sum = total sum - left sum

4. **Check Parity**: For each partition, check the parity of the left and right sums:
   - If both sums are even or both are odd, the difference is even. Increment a counter for valid partitions.

5. **Return the Count**: After iterating through all possible partition indices, return the count of valid partitions.

### Data Structures:
- A simple integer variable to keep track of the left sum.
- An integer counter to count valid partitions.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array. We make a single pass through the array to compute the sums and check the conditions.
- **Space Complexity**: O(1), as we are using a constant amount of extra space regardless of the input size.

This approach efficiently counts the valid partitions by focusing on the properties of even and odd sums, avoiding the need for nested loops or complex data structures.
