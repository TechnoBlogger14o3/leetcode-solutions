# Find Median from Data Stream

## Problem Statement

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

Implement the MedianFinder class:

- `MedianFinder()` initializes the `MedianFinder` object.
- `void addNum(int num)` adds the integer `num` from the data stream to the data structure.
- `double findMedian()` returns the median of all elements so far.

## Examples

**Example 1:**
```
Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]

Output
[null, null, null, 1.5, null, 2.0]
```

## Approach

### Method 1: Two Heaps (Recommended)
1. Use max heap for smaller half
2. Use min heap for larger half
3. Keep heaps balanced (size difference <= 1)
4. Median is top of larger heap or average of both tops

**Time Complexity:** O(log n) for addNum, O(1) for findMedian
**Space Complexity:** O(n) - Store all numbers

### Method 2: Sorting
1. Use List to store all numbers
2. Sort after each addition
3. Find median from sorted list
4. Less efficient than heaps

**Time Complexity:** O(n log n) for addNum, O(1) for findMedian
**Space Complexity:** O(n) - Store all numbers

## Algorithm

```
1. Initialize max heap (smaller half) and min heap (larger half)
2. For addNum:
   a. Add to max heap
   b. Move max to min heap
   c. If min heap size > max heap size: move min to max heap
3. For findMedian:
   a. If sizes equal: return average of both tops
   b. Else: return top of larger heap
```

## Key Insights

- **Two Heaps**: Maintain two balanced heaps
- **Max Heap**: Store smaller half
- **Min Heap**: Store larger half
- **Balance**: Keep size difference <= 1

## Alternative Approaches

1. **Sorting**: Use sorting after each addition
2. **TreeMap**: Use TreeMap for ordering
3. **AVL Tree**: Use self-balancing tree

## Edge Cases

- Empty stream: Handle appropriately
- Single element: Return that element
- Two elements: Return average
- All same elements: Handle appropriately

## Applications

- Data streams
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Two Heaps**: Most efficient approach
- **Logarithmic Time**: O(log n) per addition
- **Constant Time**: O(1) for median
- **Memory Efficient**: O(n) space complexity
