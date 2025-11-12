# Minimum Number of Operations to Make All Array Elements Equal to 1 (Medium)

**Problem ID:** 2654  
**Date:** 2025-11-12  
**Link:** https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/

## Approach

To solve the problem of minimizing the number of operations required to make all elements of the array equal to 1, we can follow a systematic approach:

### Problem Breakdown
1. **Understanding GCD Operations**: The operation allows us to replace either `nums[i]` or `nums[i+1]` with their greatest common divisor (GCD). This means we can reduce the values in the array, but we need to ensure that we can eventually reach the value 1 for all elements.

2. **Feasibility Check**: Before attempting to compute the number of operations, we must check if it's possible to make all elements equal to 1. This can be determined by calculating the GCD of the entire array:
   - If `gcd(nums) != 1`, it is impossible to reduce all elements to 1, and we should return -1.

3. **Finding Minimum Operations**: If it is feasible to make all elements equal to 1, we need to determine the minimum number of operations:
   - We can leverage the fact that we can replace any two adjacent elements with their GCD. The goal is to propagate the value 1 through the array.
   - We can iterate through the array and track the positions where we can achieve a GCD of 1. Specifically, we can look for the first occurrence of 1 and the last occurrence of 1 in the array, as these positions will dictate how many operations are needed to convert the rest of the elements to 1.

### Approach
1. **Calculate GCD of the Array**: Use a helper function to compute the GCD of the entire array. If the result is greater than 1, return -1.

2. **Locate Positions of 1**: Traverse the array to find the first and last indices where the value is 1. If there are no 1s, we will need to convert elements to 1 by propagating from adjacent elements.

3. **Count Operations**: 
   - If there are existing 1s, the number of operations needed can be calculated based on the distance to the nearest 1 from both ends of the array.
   - If there are no 1s, we will need to perform operations on adjacent pairs until we create a 1. The maximum number of operations will be determined by the length of the array minus the number of contiguous segments we can create with GCD operations.

### Data Structures
- A simple array to hold the input values is sufficient.
- Basic integer variables to track indices and counts.

### Complexity
- **Time Complexity**: O(n) for calculating the GCD and O(n) for finding the first and last occurrences of 1, leading to an overall complexity of O(n).
- **Space Complexity**: O(1) since we are using a constant amount of extra space.

By following this structured approach, we can efficiently determine the minimum number of operations required to make all elements of the array equal to 1 or conclude that it is impossible.
