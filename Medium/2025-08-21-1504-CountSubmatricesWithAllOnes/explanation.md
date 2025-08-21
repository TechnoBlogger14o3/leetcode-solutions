# Count Submatrices with All Ones

## Problem Description
Given a 2D binary matrix filled with 0's and 1's, return the number of submatrices with all ones. A submatrix is any rectangular subarray of the matrix.

## Approach
This is a dynamic programming problem that requires counting all possible rectangular submatrices (not just squares). The key insight is to count submatrices ending at each position by considering different heights and widths.

## Algorithm
1. **Iterate through each position**: For each cell `(i,j)` with value 1
2. **Count submatrices ending at position**: Use helper function to count all possible submatrices
3. **Try different heights**: For each height from 0 to current row
4. **Calculate consecutive 1s**: Count consecutive 1s in each row from current column backwards
5. **Update maxWidth**: Take minimum of consecutive 1s across all rows in current height
6. **Accumulate count**: Add maxWidth for each height

## Key Implementation Details
- **Height Variation**: Try submatrices of different heights ending at current row
- **Width Calculation**: Count consecutive 1s from current column backwards
- **Min Width Constraint**: Width is limited by the minimum consecutive 1s across all rows
- **Early Termination**: Stop counting when encountering 0

## Mathematical Intuition
For a submatrix ending at position `(i,j)`:
- **Height h**: Number of rows from `i-h+1` to `i`
- **Width w**: Minimum consecutive 1s across all rows in height h
- **Count**: Sum of widths for all possible heights

## Time Complexity
- **Time**: O(m²n²) where m and n are the dimensions of the matrix
  - O(mn) for iterating through each position
  - O(mn) for counting submatrices at each position
- **Space**: O(1) - only using constant extra space

## Example
- Input: [[1,0,1], [1,1,0], [1,1,0]]
- Process: 
  - Position (0,0): 1 submatrix of size 1×1
  - Position (0,2): 1 submatrix of size 1×1
  - Position (1,0): 2 submatrices (1×1 and 2×1)
  - Position (1,1): 1 submatrix of size 1×1
  - Position (2,0): 3 submatrices (1×1, 2×1, and 3×1)
  - Position (2,1): 1 submatrix of size 1×1
- Output: 9

## Key Insights
- **Rectangular vs Square**: This problem counts all rectangles, not just squares
- **Ending Position**: Count submatrices ending at each position
- **Height Variation**: Try different heights for each position
- **Width Constraint**: Width is limited by the weakest row in current height

## Alternative Approaches
- **Brute Force**: Check all possible submatrices (O(m³n³))
- **Prefix Sums**: Use 2D prefix sums for faster area calculation
- **Monotonic Stack**: Use stack to optimize width calculation
- **Dynamic Programming**: Build solution incrementally

## Edge Cases
- **Empty Matrix**: Return 0
- **Single Element**: Handle 1×1 matrices
- **All Zeros**: Return 0
- **All Ones**: Maximum possible submatrices
- **Irregular Patterns**: Handle mixed 0s and 1s

## Applications
- **Image Processing**: Count objects or patterns
- **Computer Vision**: Detect rectangular regions
- **Data Analysis**: Find clusters or patterns in binary data
- **Game Development**: Count valid game board positions
- **Document Analysis**: Count text blocks or regions

## Optimization Opportunities
- **Early Termination**: Stop when encountering 0
- **Caching**: Store intermediate results for repeated calculations
- **Bit Manipulation**: Use bit operations for faster processing
- **Parallel Processing**: Process rows independently
