# Trapping Rain Water

## Problem Statement

Given `n` non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

## Examples

**Example 1:**
```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
```

**Example 2:**
```
Input: height = [4,2,0,3,2,5]
Output: 9
```

## Approach

### Method 1: Two Pointers (Recommended)
1. Use two pointers starting from both ends
2. Keep track of maximum heights from left and right
3. Water trapped at current position = min(maxLeft, maxRight) - height[i]
4. Move pointer with smaller maximum height

**Time Complexity:** O(n) - Single pass through the array
**Space Complexity:** O(1) - Only using two pointers

### Method 2: Dynamic Programming
1. Precompute maximum heights from left and right
2. Calculate trapped water for each position
3. Sum all trapped water

**Time Complexity:** O(n) - Three passes
**Space Complexity:** O(n) - For left and right arrays

## Algorithm

```
1. Initialize left = 0, right = height.length - 1
2. Initialize maxLeft = 0, maxRight = 0, water = 0
3. While left < right:
   a. If height[left] < height[right]:
      - If height[left] >= maxLeft: maxLeft = height[left]
      - Else: water += maxLeft - height[left]
      - left++
   b. Else:
      - If height[right] >= maxRight: maxRight = height[right]
      - Else: water += maxRight - height[right]
      - right--
4. Return water
```

## Key Insights

- **Two Pointers**: Efficient O(1) space solution
- **Greedy Strategy**: Always process the side with smaller maximum
- **Water Formula**: min(maxLeft, maxRight) - currentHeight
- **Boundary Effect**: Water trapped depends on minimum of two boundaries

## Alternative Approaches

1. **Dynamic Programming**: Precompute max heights - O(n) space
2. **Stack**: Use stack to find trapped water - O(n) space
3. **Brute Force**: For each position, find max heights - O(n²) time

## Edge Cases

- Empty array: Return 0
- Single element: Return 0
- All increasing: Return 0
- All decreasing: Return 0
- All same height: Return 0

## Applications

- Water resource management
- Algorithm design patterns
- Interview preparation
- Resource optimization
- Geometric problems

## Optimization Opportunities

- **Two Pointers**: Most efficient O(1) space solution
- **Single Pass**: Process both sides simultaneously
- **Early Exit**: Stop when pointers meet
- **Memory Efficient**: No extra arrays needed
