# Diagonal Traverse - Problem #498

## Problem Description
Given an `m x n` matrix `mat`, return an array of all the elements of the array in a diagonal order.

## Examples
```
Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]

Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]
```

## Approach
This is a matrix traversal problem that requires understanding the diagonal pattern. The key insight is that elements on the same diagonal have the same sum of their row and column indices.

## Algorithm
1. **Identify diagonal groups**: Elements on the same diagonal have `row + col = constant`
2. **Group by diagonal sum**: Use a map or array to group elements by their diagonal sum
3. **Reverse odd diagonals**: Diagonals with even sum go from bottom-left to top-right, odd diagonals go from top-left to bottom-right
4. **Flatten result**: Combine all diagonals in order

## Key Implementation Details
- **Diagonal Sum**: Use `row + col` to identify which diagonal an element belongs to
- **Direction Alternation**: Even diagonals go up-right, odd diagonals go down-left
- **Boundary Handling**: Ensure we don't go out of matrix bounds
- **Ordering**: Process diagonals in order of increasing sum

## Mathematical Intuition
The diagonal pattern follows these rules:
- **Diagonal Sum**: Elements on diagonal `i` have `row + col = i`
- **Direction**: 
  - Even diagonals (0, 2, 4, ...): traverse from bottom-left to top-right
  - Odd diagonals (1, 3, 5, ...): traverse from top-left to bottom-right
- **Order**: Process diagonals in order of increasing sum

## Time Complexity
- **Time**: O(m × n) where m and n are the dimensions of the matrix
- **Space**: O(m × n) for the result array

## Example Walkthrough
For input `[[1,2,3],[4,5,6],[7,8,9]]`:
- Diagonal 0: [1] (sum = 0)
- Diagonal 1: [2,4] (sum = 1) → [4,2] (reversed)
- Diagonal 2: [3,5,7] (sum = 2) → [7,5,3] (reversed)
- Diagonal 3: [6,8] (sum = 3) → [6,8]
- Diagonal 4: [9] (sum = 4)
- Result: [1,4,2,7,5,3,6,8,9]

## Key Insights
- **Diagonal Identification**: Use row + col sum to group elements
- **Direction Pattern**: Even diagonals go up-right, odd diagonals go down-left
- **Boundary Conditions**: Handle edge cases for rectangular matrices
- **Efficient Grouping**: Use a map or array to group elements by diagonal

## Alternative Approaches
- **Simulation**: Simulate the diagonal traversal step by step
- **BFS/DFS**: Use graph traversal with diagonal neighbors
- **Coordinate Mapping**: Map each position to its diagonal order
- **Iterative**: Use nested loops with direction changes

## Edge Cases
- **Empty Matrix**: Return empty array
- **Single Row/Column**: Handle 1D matrices
- **Rectangular Matrix**: Handle non-square matrices
- **Single Element**: Handle 1×1 matrices

## Applications
- **Image Processing**: Traverse image pixels in diagonal patterns
- **Matrix Operations**: Special matrix traversal for algorithms
- **Game Development**: Diagonal movement patterns
- **Data Visualization**: Diagonal data presentation
- **Pattern Recognition**: Diagonal feature extraction

## Optimization Opportunities
- **Memory Access**: Optimize matrix traversal pattern
- **Early Termination**: Stop when all elements are processed
- **Vectorization**: Use SIMD operations for large matrices
- **Cache Optimization**: Access matrix elements in cache-friendly order

## Related Problems
- **Spiral Matrix**: Traverse matrix in spiral order
- **Rotate Image**: Rotate matrix by 90 degrees
- **Matrix Traversal**: Various matrix exploration problems
- **Path Finding**: Find paths in matrix grids
