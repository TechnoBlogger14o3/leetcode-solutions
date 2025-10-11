# Spiral Matrix

## Problem Statement

Given an `m x n` matrix, return all elements of the matrix in spiral order.

## Examples

**Example 1:**
```
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
```

## Approach

### Method 1: Boundary Traversal (Recommended)
1. Use four boundaries: top, bottom, left, right
2. Traverse each boundary and shrink boundaries
3. Most efficient approach

**Time Complexity:** O(m * n) - Visit each element once
**Space Complexity:** O(1) - Excluding output array

### Method 2: Direction Array
1. Use direction array to change direction
2. Track visited cells
3. Less efficient than boundary approach

**Time Complexity:** O(m * n) - Visit each element once
**Space Complexity:** O(m * n) - Visited array

## Algorithm

```
1. Initialize boundaries: top=0, bottom=m-1, left=0, right=n-1
2. While top <= bottom and left <= right:
   a. Traverse top row: left to right
   b. Traverse right column: top+1 to bottom
   c. Traverse bottom row: right-1 to left (if top != bottom)
   d. Traverse left column: bottom-1 to top+1 (if left != right)
   e. Shrink boundaries
3. Return result
```

## Key Insights

- **Boundary Traversal**: Use four boundaries for efficient traversal
- **Local Optimum**: Traverse each boundary completely
- **Global Optimum**: Visit all elements in spiral order
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Direction Array**: Use direction array with visited tracking
2. **Recursive**: Use recursive approach
3. **Layer by Layer**: Process layer by layer

## Edge Cases

- Single row: Traverse left to right
- Single column: Traverse top to bottom
- Single element: Return that element
- Empty matrix: Return empty list

## Applications

- Matrix traversal
- Spiral algorithms
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Boundary Traversal**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Linear Time**: O(m * n) time complexity
- **No Extra Space**: Use only necessary space
