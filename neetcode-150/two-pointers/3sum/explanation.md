# 3Sum

## Problem Statement

Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

## Examples

**Example 1:**
```
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
```

**Example 2:**
```
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
```

## Approach

### Method 1: Two Pointers (Recommended)
1. Sort the array
2. Fix first element, use two pointers for remaining two
3. Skip duplicates to avoid duplicate triplets
4. Move pointers based on sum comparison

**Time Complexity:** O(n²) - Two nested loops
**Space Complexity:** O(1) - Excluding output array

### Method 2: HashSet
1. Use HashSet to store complements
2. More complex duplicate handling

**Time Complexity:** O(n²) - Two nested loops
**Space Complexity:** O(n) - For HashSet

## Algorithm

```
1. Sort the array
2. For each i from 0 to n-3:
   a. Skip duplicates for first element
   b. Initialize left = i+1, right = n-1
   c. While left < right:
      - Calculate sum = nums[i] + nums[left] + nums[right]
      - If sum == 0: Add triplet, skip duplicates, move pointers
      - Else if sum < 0: left++
      - Else: right--
3. Return all triplets
```

## Key Insights

- **Sorting**: Essential for two-pointer technique and duplicate handling
- **Skip Duplicates**: Avoid duplicate triplets by skipping same values
- **Two Pointers**: Efficient way to find pairs that sum to target
- **Fixed Element**: Fix first element, find pairs for remaining two

## Alternative Approaches

1. **HashSet**: Use set to store complements
2. **Brute Force**: Check all triplets (not recommended)
3. **Recursive**: Backtracking approach

## Edge Cases

- Empty array: Return empty list
- Less than 3 elements: Return empty list
- All zeros: Return one triplet [0,0,0]
- No valid triplets: Return empty list
- Duplicate elements: Handle carefully

## Applications

- Data analysis
- Algorithm design patterns
- Interview preparation
- Mathematical computations
- Search algorithms

## Optimization Opportunities

- **Early Exit**: Skip when first element > 0
- **Duplicate Skipping**: Efficient duplicate handling
- **Two Pointers**: Optimal approach for sorted array
- **Memory Efficient**: O(1) extra space
