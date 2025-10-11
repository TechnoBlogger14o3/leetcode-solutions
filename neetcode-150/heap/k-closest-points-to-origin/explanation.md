# K Closest Points to Origin

## Problem Statement

Given an array of `points` where `points[i] = [xi, yi]` represents a point on the X-Y plane and an integer `k`, return the `k` closest points to the origin `(0, 0)`.

The distance between two points on the X-Y plane is the Euclidean distance (i.e., `√((x1 - x2)² + (y1 - y2)²)`).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

## Examples

**Example 1:**
```
Input: points = [[1,1],[2,2],[3,3]], k = 1
Output: [[1,1]]
```

**Example 2:**
```
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
```

## Approach

### Method 1: Max Heap (Recommended)
1. Use max heap to keep k closest points
2. Calculate distance for each point
3. Maintain heap size k
4. Return all points in heap

**Time Complexity:** O(n log k) - n points, heap size k
**Space Complexity:** O(k) - Heap size

### Method 2: Sorting
1. Calculate distance for all points
2. Sort by distance
3. Return first k points

**Time Complexity:** O(n log n) - Sorting
**Space Complexity:** O(1) - In-place sorting

## Algorithm

```
1. Initialize max heap with custom comparator
2. For each point:
   a. Calculate distance from origin
   b. If heap size < k: add point
   c. Else if distance < max distance: replace max point
3. Return all points in heap
```

## Key Insights

- **Max Heap**: Keep k closest points
- **Distance Calculation**: Use Euclidean distance
- **Heap Size**: Maintain size k
- **Efficient**: O(n log k) time complexity

## Alternative Approaches

1. **Sorting**: Sort all points by distance
2. **Quick Select**: Use quick select algorithm
3. **Min Heap**: Use min heap with all points

## Edge Cases

- k = 1: Return closest point
- k = n: Return all points
- Duplicate distances: Handle appropriately
- Empty array: Return empty array

## Applications

- Computational geometry
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **Max Heap**: Most efficient approach
- **Distance Optimization**: Avoid square root calculation
- **Heap Size**: O(k) space complexity
- **Single Pass**: Process all points once
