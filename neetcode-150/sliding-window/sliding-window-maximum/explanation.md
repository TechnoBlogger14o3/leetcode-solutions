# Sliding Window Maximum

## Problem Statement

You are given an array of integers `nums`, there is a sliding window of size `k` which is moving from the very left of the array to the very right. You can only see the `k` numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

## Examples

**Example 1:**
```
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
```

## Approach

### Method 1: Deque (Recommended)
1. Use deque to store indices of elements
2. Maintain deque in decreasing order of values
3. Front of deque always contains maximum element index
4. Remove indices outside current window

**Time Complexity:** O(n) - Each element added/removed once
**Space Complexity:** O(k) - Deque size at most k

### Method 2: Priority Queue
1. Use max heap to track maximum elements
2. Remove elements outside window
3. Extract maximum for each window

**Time Complexity:** O(n log k) - Heap operations
**Space Complexity:** O(k) - Heap size

## Algorithm

```
1. Initialize deque and result array
2. For each element at index i:
   a. Remove indices outside current window from deque
   b. Remove indices with smaller values from deque
   c. Add current index to deque
   d. If window size >= k: add maximum to result
3. Return result array
```

## Key Insights

- **Deque**: Double-ended queue for efficient operations
- **Index Storage**: Store indices instead of values
- **Decreasing Order**: Maintain deque in decreasing order
- **Window Management**: Remove elements outside window

## Alternative Approaches

1. **Priority Queue**: Use max heap - O(n log k) time
2. **Brute Force**: Check all windows - O(nk) time
3. **Segment Tree**: More complex data structure

## Edge Cases

- k = 1: Return original array
- k = array length: Return array with single maximum
- All same elements: Return array of same values
- Decreasing array: Return first k elements

## Applications

- Data streaming
- Algorithm design patterns
- Interview preparation
- Performance monitoring
- Real-time analytics

## Optimization Opportunities

- **Deque**: Most efficient approach
- **Index Tracking**: Avoid storing duplicate values
- **Single Pass**: Process each element once
- **Memory Efficient**: O(k) space complexity
