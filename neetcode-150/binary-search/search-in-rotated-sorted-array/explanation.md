# Search in Rotated Sorted Array

## Problem Statement

There is an integer array `nums` sorted in ascending order (with **distinct** values).

Prior to being passed to your function, `nums` is **possibly rotated** at an unknown pivot index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (0-indexed). For example, `[0,1,2,4,5,6,7]` might be rotated at pivot index `3` and become `[4,5,6,7,0,1,2]`.

Given the array `nums` **after** the possible rotation and an integer `target`, return the index of `target` in `nums`, or `-1` if it is not in `nums`.

You must write an algorithm with `O(log n)` runtime complexity.

## Examples

**Example 1:**
```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

**Example 2:**
```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

## Approach

### Method 1: Binary Search (Recommended)
1. Use binary search to find target in rotated array
2. Determine which half is sorted
3. Check if target is in sorted half
4. Adjust search range accordingly

**Time Complexity:** O(log n) - Binary search
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Two Pass
1. First find rotation point
2. Then search in appropriate half

**Time Complexity:** O(log n) - Two binary searches
**Space Complexity:** O(1) - Only uses constant extra space

## Algorithm

```
1. Initialize left = 0, right = n - 1
2. While left <= right:
   a. Calculate mid = left + (right - left) / 2
   b. If nums[mid] == target: return mid
   c. If nums[left] <= nums[mid]: left half is sorted
      - If target in [nums[left], nums[mid]]: right = mid - 1
      - Else: left = mid + 1
   d. Else: right half is sorted
      - If target in [nums[mid], nums[right]]: left = mid + 1
      - Else: right = mid - 1
3. Return -1
```

## Key Insights

- **Rotation Detection**: Determine which half is sorted
- **Target Range**: Check if target is in sorted half
- **Binary Search**: Use binary search on rotated array
- **Distinct Values**: No duplicates to handle

## Alternative Approaches

1. **Two Pass**: Find rotation point first
2. **Linear Search**: O(n) time complexity
3. **Mathematical**: Calculate rotation point directly

## Edge Cases

- Single element: Check if equals target
- No rotation: Standard binary search
- Full rotation: Standard binary search
- Target not found: Return -1
- Target at boundaries: Handle first/last elements

## Applications

- Array rotation problems
- Binary search variations
- Algorithm design patterns
- Interview preparation
- Data structure operations

## Optimization Opportunities

- **Binary Search**: Most efficient approach
- **Rotation Detection**: Efficient half determination
- **Early Termination**: Stop when found
- **Memory Efficient**: O(1) space complexity
