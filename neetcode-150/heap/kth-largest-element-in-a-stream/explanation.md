# Kth Largest Element in a Stream

## Problem Statement

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in sorted order, not the kth distinct element.

Implement `KthLargest` class:

- `KthLargest(int k, int[] nums)` Initializes the object with the integer `k` and the stream of integers `nums`.
- `int add(int val)` Appends the integer `val` to the stream and returns the element representing the kth largest element in the stream.

## Examples

**Example 1:**
```
Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]

Output
[null, 4, 5, 5, 8, 8]
```

## Approach

### Method 1: Min Heap (Recommended)
1. Use a min heap of size k
2. Keep only the k largest elements
3. The root of the heap is the kth largest element
4. When adding new element, maintain heap size

**Time Complexity:** O(log k) for add operation
**Space Complexity:** O(k) - Heap size

### Method 2: Max Heap with Sorting
1. Use max heap to store all elements
2. Sort and find kth largest each time
3. Less efficient but simpler

**Time Complexity:** O(n log n) for add operation
**Space Complexity:** O(n) - All elements

## Algorithm

```
1. Initialize min heap with first k elements
2. For remaining elements:
   - If heap size < k: add element
   - Else if element > heap.peek(): remove min, add element
3. Add operation:
   - If heap size < k: add element
   - Else if element > heap.peek(): remove min, add element
   - Return heap.peek()
```

## Key Insights

- **Min Heap**: Keep k largest elements
- **Heap Size**: Maintain size k
- **Root Element**: Always the kth largest
- **Efficient**: O(log k) per operation

## Alternative Approaches

1. **Max Heap**: Use max heap with sorting
2. **Quick Select**: Use quick select algorithm
3. **Sorted Array**: Maintain sorted array

## Edge Cases

- Empty stream: Handle appropriately
- k = 1: Return maximum element
- k = n: Return minimum element
- Duplicate elements: Handle appropriately

## Applications

- Data streams
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Min Heap**: Most efficient approach
- **Size Management**: Maintain heap size k
- **Logarithmic Time**: O(log k) per operation
- **Memory Efficient**: O(k) space complexity
