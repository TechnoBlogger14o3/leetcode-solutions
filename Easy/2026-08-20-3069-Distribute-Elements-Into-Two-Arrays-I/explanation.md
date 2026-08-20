# Distribute Elements Into Two Arrays I (Easy)

**Problem ID:** 3069  
**Date:** 2026-08-20  
**Link:** https://leetcode.com/problems/distribute-elements-into-two-arrays-i/

## Approach

To solve the problem of distributing elements from the given array `nums` into two arrays `arr1` and `arr2`, we can follow a straightforward iterative approach based on the specified rules.

### Main Idea:
The core idea is to maintain two separate arrays, `arr1` and `arr2`, and append elements from `nums` based on the comparison of the last elements of these arrays. The first element goes to `arr1`, the second to `arr2`, and subsequent elements are appended based on the condition that checks which of the last elements of `arr1` or `arr2` is greater.

### Approach:
1. **Initialization**: Start by creating two empty arrays, `arr1` and `arr2`.
2. **First Two Operations**: Directly append the first element of `nums` to `arr1` and the second element to `arr2`.
3. **Iterate through Remaining Elements**: For each subsequent element in `nums`, compare the last elements of `arr1` and `arr2`:
   - If the last element of `arr1` is greater than that of `arr2`, append the current element from `nums` to `arr1`.
   - Otherwise, append it to `arr2`.
4. **Concatenate Results**: After processing all elements, concatenate `arr1` and `arr2` to form the final result.

### Data Structures:
- Two lists (or arrays) `arr1` and `arr2` to store the distributed elements.

### Complexity:
- **Time Complexity**: O(n), where n is the length of the input array `nums`. This is because we iterate through the array once, performing constant-time operations for each element.
- **Space Complexity**: O(n) for storing the two output arrays, which in the worst case can contain all elements of `nums`.

This approach efficiently distributes the elements according to the specified rules and constructs the desired output in a linear fashion.
