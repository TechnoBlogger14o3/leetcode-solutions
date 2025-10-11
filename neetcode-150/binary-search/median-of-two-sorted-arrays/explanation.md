# Median of Two Sorted Arrays

## Problem Statement

Given two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively, return the **median** of the two sorted arrays.

The overall run time complexity should be `O(log (m+n))`.

## Examples

**Example 1:**
```
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
```

**Example 2:**
```
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
```

## Approach

### Method 1: Binary Search (Recommended)
1. Use binary search on the smaller array
2. Partition both arrays such that left half has same number of elements
3. Check if partition is correct by comparing boundary elements
4. Adjust partition based on comparison

**Time Complexity:** O(log(min(m,n))) - Binary search on smaller array
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Merge and Find
1. Merge both arrays into one sorted array
2. Find median of merged array

**Time Complexity:** O(m+n) - Merge operation
**Space Complexity:** O(m+n) - Store merged array

## Algorithm

```
1. Ensure nums1 is the smaller array
2. Initialize left = 0, right = m
3. While left <= right:
   a. Calculate partitionX = (left + right) / 2
   b. Calculate partitionY = (m + n + 1) / 2 - partitionX
   c. Find maxLeftX, minRightX, maxLeftY, minRightY
   d. If maxLeftX <= minRightY and maxLeftY <= minRightX:
      - Found correct partition
      - Calculate median based on total length
   e. Else if maxLeftX > minRightY: right = partitionX - 1
   f. Else: left = partitionX + 1
```

## Key Insights

- **Binary Search**: Search on partition point
- **Partition Logic**: Ensure equal elements on both sides
- **Boundary Check**: Compare boundary elements
- **Median Calculation**: Handle odd/even length cases

## Alternative Approaches

1. **Merge Arrays**: Merge and find median - O(m+n) time
2. **Two Pointers**: Use two pointers technique
3. **Mathematical**: Calculate median directly

## Edge Cases

- Empty arrays: Handle appropriately
- Single element arrays: Return that element
- All same elements: Return that element
- One array much larger: Handle efficiently
- Odd/even total length: Calculate accordingly

## Applications

- Statistics and data analysis
- Algorithm design patterns
- Interview preparation
- Database operations
- Performance optimization

## Optimization Opportunities

- **Binary Search**: Most efficient approach
- **Smaller Array**: Search on smaller array
- **Partition Logic**: Efficient boundary checking
- **Memory Efficient**: O(1) space complexity
