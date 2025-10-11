# Rotate Image

## Problem Statement

You are given an `n x n` 2D `matrix` representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

## Examples

**Example 1:**
```
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
```

## Approach

### Method 1: Transpose + Reverse (Recommended)
1. Transpose the matrix (swap matrix[i][j] with matrix[j][i])
2. Reverse each row
3. Most efficient approach

**Time Complexity:** O(n²) - Two passes
**Space Complexity:** O(1) - In-place modification

### Method 2: Layer by Layer
1. Rotate matrix layer by layer
2. Use four-way swap for each layer
3. Less efficient than transpose approach

**Time Complexity:** O(n²) - Single pass
**Space Complexity:** O(1) - In-place modification

## Algorithm

```
1. Transpose matrix: matrix[i][j] = matrix[j][i]
2. Reverse each row: reverse(matrix[i])
```

## Key Insights

- **Transpose**: Swap elements across diagonal
- **Reverse**: Reverse each row after transpose
- **In-place**: No extra space needed
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Layer by Layer**: Rotate layer by layer
2. **Four-way Swap**: Use four-way swap for each element
3. **Mathematical**: Use mathematical transformation

## Edge Cases

- Single element: No change needed
- 2x2 matrix: Simple swap
- Large matrix: Handle efficiently
- Empty matrix: Handle appropriately

## Applications

- Image processing
- Matrix operations
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Transpose + Reverse**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Quadratic Time**: O(n²) time complexity
- **No Extra Space**: Use only necessary space