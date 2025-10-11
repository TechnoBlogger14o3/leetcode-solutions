# Merge K Sorted Lists

## Problem Statement

You are given an array of `k` linked-lists `lists`, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

## Examples

**Example 1:**
```
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
```

**Example 2:**
```
Input: lists = []
Output: []
```

## Approach

### Method 1: Min Heap (Priority Queue) (Recommended)
1. Add first node of each list to min heap
2. Extract minimum node from heap
3. Add extracted node's next to heap
4. Repeat until heap is empty

**Time Complexity:** O(N log k) - N total nodes, k lists
**Space Complexity:** O(k) - Heap size

### Method 2: Divide and Conquer
1. Merge lists in pairs
2. Recursively merge resulting lists
3. Similar to merge sort

**Time Complexity:** O(N log k) - N total nodes, k lists
**Space Complexity:** O(1) - In-place merging

## Algorithm

```
1. Add first node of each list to min heap
2. While heap is not empty:
   a. Extract minimum node
   b. Add to result list
   c. If extracted node has next, add to heap
3. Return result list
```

## Key Insights

- **Min Heap**: Efficiently find minimum among k lists
- **Priority Queue**: Use priority queue for min heap
- **Merge**: Similar to merging two sorted lists
- **Efficiency**: O(N log k) time complexity

## Alternative Approaches

1. **Divide and Conquer**: Merge in pairs
2. **Brute Force**: Merge lists one by one
3. **Flat and Sort**: Flatten all, sort, rebuild

## Edge Cases

- Empty lists: Return null
- Single list: Return that list
- All empty lists: Return null
- Different lengths: Handle appropriately

## Applications

- External sorting
- Merge algorithms
- Algorithm design patterns
- Interview preparation
- Distributed systems

## Optimization Opportunities

- **Min Heap**: Most efficient approach
- **Priority Queue**: Standard library implementation
- **Divide and Conquer**: Alternative efficient approach
- **Memory Efficient**: Choose based on constraints
