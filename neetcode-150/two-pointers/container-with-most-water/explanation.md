# Container With Most Water

## Problem Statement

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `ith` line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

**Notice** that you may not slant the container.

## Examples

**Example 1:**
```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
```

**Example 2:**
```
Input: height = [1,1]
Output: 1
```

## Approach

### Method 1: Two Pointers (Recommended)
1. Use two pointers starting from both ends
2. Calculate area = min(height[left], height[right]) * (right - left)
3. Move pointer with smaller height inward
4. Keep track of maximum area

**Time Complexity:** O(n) - Single pass through the array
**Space Complexity:** O(1) - Only using two pointers

### Method 2: Brute Force
1. Check all possible pairs
2. Calculate area for each pair
3. Return maximum area

**Time Complexity:** O(n²) - Nested loops
**Space Complexity:** O(1) - No extra space

## Algorithm

```
1. Initialize left = 0, right = height.length - 1, maxArea = 0
2. While left < right:
   a. Calculate area = min(height[left], height[right]) * (right - left)
   b. Update maxArea = max(maxArea, area)
   c. If height[left] < height[right]:
      - left++
   d. Else:
      - right--
3. Return maxArea
```

## Key Insights

- **Two Pointers**: Start from both ends and move inward
- **Greedy Choice**: Always move the pointer with smaller height
- **Area Formula**: min(height[left], height[right]) * width
- **Optimal Strategy**: Moving smaller height pointer gives chance for larger area

## Alternative Approaches

1. **Brute Force**: Check all pairs - O(n²) time
2. **Dynamic Programming**: More complex approach
3. **Divide and Conquer**: Recursive approach

## Edge Cases

- Empty array: Return 0
- Single element: Return 0
- Two elements: Return min height * 1
- All same height: Return height * (n-1)
- Increasing heights: Return height[0] * (n-1)

## Applications

- Water storage optimization
- Algorithm design patterns
- Interview preparation
- Resource allocation
- Geometric problems

## Optimization Opportunities

- **Early Exit**: Stop when pointers meet
- **Greedy Strategy**: Always move smaller height pointer
- **Single Pass**: Most efficient approach
- **Memory Efficient**: O(1) space solution
