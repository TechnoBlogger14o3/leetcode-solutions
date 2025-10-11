# Binary Search

## Problem Statement

Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`.

You must write an algorithm with `O(log n)` runtime complexity.

## Examples

**Example 1:**
```
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```

**Example 2:**
```
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
```

## Approach

### Method 1: Iterative Binary Search (Recommended)
1. Use two pointers: left and right
2. Calculate middle index
3. Compare target with middle element
4. Adjust search range based on comparison
5. Continue until found or range exhausted

**Time Complexity:** O(log n) - Halves search space each iteration
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Recursive Binary Search
1. Use recursion to implement binary search
2. Base case: left > right
3. Recursive case: search left or right half

**Time Complexity:** O(log n)
**Space Complexity:** O(log n) - Recursion stack

## Algorithm

```
1. Initialize left = 0, right = n - 1
2. While left <= right:
   a. Calculate mid = left + (right - left) / 2
   b. If nums[mid] == target: return mid
   c. If nums[mid] < target: left = mid + 1
   d. If nums[mid] > target: right = mid - 1
3. Return -1 (not found)
```

## Key Insights

- **Sorted Array**: Prerequisite for binary search
- **Divide and Conquer**: Halve search space each iteration
- **Overflow Prevention**: Use left + (right - left) / 2
- **Boundary Conditions**: Handle edge cases carefully

## Alternative Approaches

1. **Recursive**: Use recursion instead of iteration
2. **Lower Bound**: Find first occurrence
3. **Upper Bound**: Find last occurrence

## Edge Cases

- Empty array: Return -1
- Single element: Check if equals target
- Target not found: Return -1
- Target at boundaries: Handle first/last elements
- Duplicate elements: Return any valid index

## Applications

- Search algorithms
- Database queries
- Algorithm design patterns
- Interview preparation
- Performance optimization

## Optimization Opportunities

- **Iterative**: Most efficient approach
- **Overflow Safe**: Prevent integer overflow
- **Early Termination**: Stop when found
- **Memory Efficient**: O(1) space complexity
