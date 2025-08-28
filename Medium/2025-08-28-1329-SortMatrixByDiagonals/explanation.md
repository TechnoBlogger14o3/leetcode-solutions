# Sort Matrix by Diagonals - Problem #1329

## Problem Description
A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the southwest direction until reaching the matrix's end. For example, the matrix diagonal starting from `mat[2][0]`, where `mat` is a 6 x 3 matrix, includes cells `mat[2][0]`, `mat[3][1]`, and `mat[4][2]`.

Given an `m x n` matrix `mat`, return a matrix of the same size where all the diagonals are sorted in ascending order.

## Examples
```
Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
Explanation: 
The diagonals are:
- [3] (from mat[0][0])
- [2,3] (from mat[1][0])
- [1,2,1] (from mat[2][0])
- [1,1,2] (from mat[0][1])
- [2,2] (from mat[1][1])
- [1] (from mat[2][1])

After sorting each diagonal:
- [3] → [3]
- [2,3] → [2,3]
- [1,2,1] → [1,1,2]
- [1,1,2] → [1,1,2]
- [2,2] → [2,2]
- [1] → [1]

The final matrix is [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
```

## Approach
This is a matrix traversal problem that requires identifying diagonals and sorting them. The key insight is that elements on the same diagonal have the same difference between their row and column indices.

## Algorithm
1. **Identify diagonal groups**: Elements on the same diagonal have `row - col = constant`
2. **Group by diagonal**: Use a map or array to group elements by their diagonal difference
3. **Sort each diagonal**: Sort the elements in each diagonal group
4. **Reconstruct matrix**: Place the sorted elements back into the matrix in diagonal order

## Key Implementation Details
- **Diagonal Identification**: Use `row - col` to identify which diagonal an element belongs to
- **Diagonal Grouping**: Collect all elements from each diagonal into separate arrays
- **Sorting**: Sort each diagonal array in ascending order
- **Matrix Reconstruction**: Place sorted elements back into the matrix following diagonal patterns

## Mathematical Intuition
The diagonal pattern follows this rule:
- **Diagonal Difference**: Elements on diagonal `i` have `row - col = i`
- **Diagonal Order**: Diagonals are processed from top-left to bottom-right
- **Element Placement**: After sorting, elements are placed back in their original diagonal positions

## Time Complexity
- **Time**: O(mn × log(min(m,n))) where m and n are the dimensions of the matrix
  - O(mn) to collect elements from all diagonals
  - O(log(min(m,n))) to sort each diagonal (worst case when diagonal length is min(m,n))
- **Space**: O(mn) for storing diagonal elements

## Example Walkthrough
For input `[[3,3,1,1],[2,2,1,2],[1,1,1,2]]`:
- Diagonal 0 (row-col=0): [3,2,1] → sorted: [1,2,3]
- Diagonal -1 (row-col=-1): [3,2,1] → sorted: [1,2,3]
- Diagonal -2 (row-col=-2): [1,2] → sorted: [1,2]
- Diagonal -3 (row-col=-3): [1] → sorted: [1]
- Diagonal 1 (row-col=1): [2,1] → sorted: [1,2]
- Diagonal 2 (row-col=2): [1] → sorted: [1]

## Key Insights
- **Diagonal Property**: Elements on the same diagonal have constant `row - col` difference
- **Grouping Strategy**: Collect all elements from each diagonal before sorting
- **Reconstruction Order**: Place sorted elements back in diagonal order
- **Boundary Handling**: Handle edge cases for rectangular matrices

## Alternative Approaches
- **In-place Sorting**: Sort diagonals directly in the matrix (more complex)
- **Priority Queue**: Use min-heap for each diagonal
- **Bucket Sort**: Use counting sort for small integer ranges
- **Two-pass**: First collect, then reconstruct

## Edge Cases
- **Empty Matrix**: Return empty matrix
- **Single Row/Column**: Handle 1D matrices
- **Rectangular Matrix**: Handle non-square matrices
- **Single Element**: Handle 1×1 matrices
- **All Same Values**: Handle matrices with identical elements

## Applications
- **Image Processing**: Sort pixel values along diagonal lines
- **Data Analysis**: Organize data by diagonal patterns
- **Matrix Operations**: Preprocessing for matrix algorithms
- **Pattern Recognition**: Analyze diagonal structures
- **Game Development**: Sort game board elements diagonally

## Optimization Opportunities
- **Early Termination**: Stop when all diagonals are processed
- **Memory Access**: Optimize matrix traversal patterns
- **Sorting Algorithm**: Choose appropriate sorting method based on data
- **In-place Operations**: Minimize extra memory usage

## Related Problems
- **Diagonal Traverse**: Traverse matrix in diagonal order
- **Rotate Image**: Rotate matrix by 90 degrees
- **Matrix Sorting**: Various matrix sorting problems
- **Grid Operations**: Other grid-based algorithms
