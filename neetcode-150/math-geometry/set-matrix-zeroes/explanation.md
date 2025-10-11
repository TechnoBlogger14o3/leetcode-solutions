# Set Matrix Zeroes

## Problem Statement

Given an `m x n` integer matrix `matrix`, if an element is `0`, set its entire row and column to `0`s.

You must do it in-place.

## Examples

**Example 1:**
```
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
```

## Approach

### Method 1: First Row and Column as Markers (Recommended)
1. Use first row and column as markers for zero rows/columns
2. Handle first row and column separately
3. Most efficient approach

**Time Complexity:** O(m * n) - Two passes
**Space Complexity:** O(1) - In-place modification

### Method 2: Additional Arrays
1. Use additional arrays to track zero rows/columns
2. Less efficient than marker approach

**Time Complexity:** O(m * n) - Two passes
**Space Complexity:** O(m + n) - Additional arrays

## Algorithm

```
1. Check if first row and column have zeros
2. Use first row and column as markers
3. Mark rows and columns that should be zero
4. Set zeros based on markers
5. Handle first row and column separately
```

## Key Insights

- **Marker Technique**: Use first row/column as markers
- **Local Optimum**: Mark all zero positions efficiently
- **Global Optimum**: Set all zeros in-place
- **Space Optimization**: Use only necessary space

## Alternative Approaches

1. **Additional Arrays**: Use separate arrays for tracking
2. **Hash Set**: Use hash sets for zero positions
3. **Brute Force**: Check all positions

## Edge Cases

- Single row: Handle row zeros
- Single column: Handle column zeros
- All zeros: Set entire matrix to zero
- No zeros: No changes needed

## Applications

- Matrix operations
- Image processing
- Algorithm design patterns
- Interview preparation
- System design

## Optimization Opportunities

- **Marker Technique**: Most efficient approach
- **Space Optimization**: O(1) space complexity
- **Linear Time**: O(m * n) time complexity
- **No Extra Space**: Use only necessary space
