# Daily Temperatures

## Problem Statement

Given an array of integers `temperatures` represents the daily temperatures, return an array `answer` such that `answer[i]` is the number of days you have to wait after the `ith` day to get a warmer temperature. If there is no future day for which this is possible, keep `answer[i] == 0` instead.

## Examples

**Example 1:**
```
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
```

**Example 2:**
```
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
```

## Approach

### Method 1: Monotonic Stack (Recommended)
1. Use stack to store indices of temperatures
2. For each temperature, pop indices with lower temperatures
3. Calculate days difference for each popped index
4. Push current index to stack

**Time Complexity:** O(n) - Each element pushed/popped once
**Space Complexity:** O(n) - Stack can hold all indices

### Method 2: Brute Force
1. For each day, find next warmer day
2. More straightforward but less efficient

**Time Complexity:** O(n²) - Nested loops
**Space Complexity:** O(1) - Excluding output array

## Algorithm

```
1. Initialize empty stack and result array
2. For each temperature at index i:
   a. While stack not empty and current temp > stack top temp:
      - Pop index from stack
      - Set result[index] = i - index
   b. Push current index to stack
3. Return result array
```

## Key Insights

- **Monotonic Stack**: Maintain decreasing temperature order
- **Index Storage**: Store indices instead of values
- **Days Calculation**: Difference between current and stored index
- **Next Greater**: Find next greater element pattern

## Alternative Approaches

1. **Brute Force**: Check all future days - O(n²) time
2. **Dynamic Programming**: More complex approach
3. **Two Pointers**: Use two pointers technique

## Edge Cases

- Empty array: Return empty array
- Single element: Return [0]
- All increasing: Return [1,1,1,...,0]
- All decreasing: Return [0,0,0,...,0]
- All same temperatures: Return [0,0,0,...,0]

## Applications

- Weather forecasting
- Algorithm design patterns
- Interview preparation
- Data analysis
- Time series analysis

## Optimization Opportunities

- **Monotonic Stack**: Most efficient approach
- **Single Pass**: Process each element once
- **Memory Efficient**: Only store necessary indices
- **Early Termination**: Stop when stack empty
