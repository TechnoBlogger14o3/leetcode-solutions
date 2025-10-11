# Find Minimum in Rotated Sorted Array

## Problem Statement

Suppose an array of length `n` sorted in ascending order is **rotated** between `1` and `n` times. For example, the array `nums = [0,1,2,4,5,6,7]` might become:

- `[4,5,6,7,0,1,2]` if it was rotated `4` times.
- `[0,1,2,4,5,6,7]` if it was rotated `7` times.

Notice that **rotating** an array `[a[0], a[1], a[2], ..., a[n-1]]` 1 time results in the array `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.

Given the sorted rotated array `nums` of **unique** elements, return the minimum element of this array.

You must write an algorithm that runs in `O(log n)` time.

## Examples

**Example 1:**
```
Input: nums = [3,4,5,1,2]
Output: 1
```

**Example 2:**
```
Input: nums = [4,5,6,7,0,1,2]
Output: 0
```

## Approach

### Method 1: Binary Search (Recommended)
1. Use binary search to find rotation point
2. Compare middle element with rightmost element
3. If mid > right: minimum is in right half
4. If mid < right: minimum is in left half (including mid)
5. Continue until found

**Time Complexity:** O(log n) - Binary search
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Linear Search
1. Find the rotation point by linear search
2. Return the element at rotation point

**Time Complexity:** O(n) - Linear search
**Space Complexity:** O(1) - Only uses constant extra space

## Algorithm

```
1. Initialize left = 0, right = n - 1
2. While left < right:
   a. Calculate mid = left + (right - left) / 2
   b. If nums[mid] > nums[right]: left = mid + 1
   c. Else: right = mid
3. Return nums[left]
```

## Key Insights

- **Rotation Point**: Find where array is rotated
- **Binary Search**: Use binary search to find minimum
- **Comparison**: Compare with rightmost element
- **Unique Elements**: No duplicates to handle

## Alternative Approaches

1. **Linear Search**: Find rotation point linearly
2. **Two Pointers**: Use two pointers technique
3. **Mathematical**: Calculate rotation point directly

## Edge Cases

- Single element: Return that element
- No rotation: Return first element
- Full rotation: Return first element
- Two elements: Return smaller element
- All same elements: Return any element

## Applications

- Array rotation problems
- Binary search variations
- Algorithm design patterns
- Interview preparation
- Data structure operations

## Optimization Opportunities

- **Binary Search**: Most efficient approach
- **Right Comparison**: Compare with rightmost element
- **Early Termination**: Stop when found
- **Memory Efficient**: O(1) space complexity
