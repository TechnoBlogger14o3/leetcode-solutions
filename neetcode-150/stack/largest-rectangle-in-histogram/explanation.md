# Largest Rectangle in Histogram

## Problem Statement

Given an array of integers `heights` representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

## Examples

**Example 1:**
```
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
```

**Example 2:**
```
Input: heights = [2,4]
Output: 4
```

## Approach

### Method 1: Monotonic Stack (Recommended)
1. Use stack to store indices of increasing heights
2. For each bar, pop bars with greater heights
3. Calculate area for each popped bar
4. Keep track of maximum area

**Time Complexity:** O(n) - Each bar pushed/popped once
**Space Complexity:** O(n) - Stack can hold all indices

### Method 2: Brute Force
1. For each bar, find left and right boundaries
2. Calculate area for each bar
3. Return maximum area

**Time Complexity:** O(n²) - Nested loops
**Space Complexity:** O(1) - No extra space

## Algorithm

```
1. Initialize stack and maxArea = 0
2. For each bar at index i:
   a. While stack not empty and current height < stack top height:
      - Pop index from stack
      - Calculate area = height[popped] * (i - stack.top() - 1)
      - Update maxArea
   b. Push current index to stack
3. Process remaining bars in stack
4. Return maxArea
```

## Key Insights

- **Monotonic Stack**: Maintain increasing height order
- **Area Calculation**: height * width (right - left - 1)
- **Boundary Handling**: Use stack to find left boundary
- **Remaining Bars**: Process bars left in stack

## Alternative Approaches

1. **Brute Force**: Check all possible rectangles - O(n²) time
2. **Divide and Conquer**: Recursive approach
3. **Dynamic Programming**: More complex state tracking

## Edge Cases

- Empty array: Return 0
- Single bar: Return bar height
- All same height: Return height * length
- Increasing heights: Return max height
- Decreasing heights: Return sum of all heights

## Applications

- Histogram analysis
- Algorithm design patterns
- Interview preparation
- Data visualization
- Geometric problems

## Optimization Opportunities

- **Monotonic Stack**: Most efficient approach
- **Single Pass**: Process each bar once
- **Memory Efficient**: Only store necessary indices
- **Early Termination**: Stop when stack empty
