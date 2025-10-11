# Kth Largest Element in an Array

## Problem Statement

Given an integer array `nums` and an integer `k`, return the kth largest element in the array.

Note that it is the kth largest element in sorted order, not the kth distinct element.

## Examples

**Example 1:**
```
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
```

**Example 2:**
```
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
```

## Approach

### Method 1: Min Heap (Recommended)
1. Use min heap of size k
2. Keep only the k largest elements
3. The root of the heap is the kth largest element
4. More efficient for large arrays

**Time Complexity:** O(n log k) - n elements, heap size k
**Space Complexity:** O(k) - Heap size

### Method 2: Quick Select
1. Use quick select algorithm
2. Partition array around pivot
3. Recursively select from appropriate partition
4. Average case O(n), worst case O(n²)

**Time Complexity:** O(n) average, O(n²) worst case
**Space Complexity:** O(1) - In-place

## Algorithm

```
1. Initialize min heap of size k
2. For each element in array:
   a. If heap size < k: add element
   b. Else if element > heap.peek(): remove min, add element
3. Return heap.peek()
```

## Key Insights

- **Min Heap**: Keep k largest elements
- **Heap Size**: Maintain size k
- **Root Element**: Always the kth largest
- **Efficient**: O(n log k) time complexity

## Alternative Approaches

1. **Quick Select**: Use quick select algorithm
2. **Sorting**: Sort array and return kth element
3. **Max Heap**: Use max heap with all elements

## Edge Cases

- k = 1: Return maximum element
- k = n: Return minimum element
- Duplicate elements: Handle appropriately
- Single element: Return that element

## Applications

- Order statistics
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Min Heap**: Most efficient approach
- **Size Management**: Maintain heap size k
- **Logarithmic Time**: O(log k) per operation
- **Memory Efficient**: O(k) space complexity
