# Search 2D Matrix

## Problem Statement

Write an efficient algorithm that searches for a value `target` in an `m x n` integer matrix. This matrix has the following properties:

- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.

## Examples

**Example 1:**
```
Input: matrix = [[1,4,7,11],[2,5,8,12],[3,6,9,16],[10,13,14,17]], target = 5
Output: true
```

**Example 2:**
```
Input: matrix = [[1,4,7,11],[2,5,8,12],[3,6,9,16],[10,13,14,17]], target = 3
Output: false
```

## Approach

### Method 1: Binary Search on Flattened Array (Recommended)
1. Treat 2D matrix as 1D sorted array
2. Use binary search with index conversion
3. Convert 1D index to 2D coordinates
4. Search efficiently in O(log(mn)) time

**Time Complexity:** O(log(mn)) - Binary search on flattened array
**Space Complexity:** O(1) - Only uses constant extra space

### Method 2: Two Binary Searches
1. First binary search to find correct row
2. Second binary search within that row
3. More intuitive but slightly less efficient

**Time Complexity:** O(log m + log n) - Two binary searches
**Space Complexity:** O(1) - Only uses constant extra space

## Algorithm

```
1. Initialize left = 0, right = m * n - 1
2. While left <= right:
   a. Calculate mid = left + (right - left) / 2
   b. Convert mid to 2D coordinates: row = mid / n, col = mid % n
   c. If matrix[row][col] == target: return true
   d. If matrix[row][col] < target: left = mid + 1
   e. If matrix[row][col] > target: right = mid - 1
3. Return false
```

## Key Insights

- **Flattened Array**: Treat 2D matrix as 1D sorted array
- **Index Conversion**: Convert 1D index to 2D coordinates
- **Sorted Properties**: Both row-wise and overall sorted
- **Efficient Search**: Single binary search instead of two

## Alternative Approaches

1. **Two Binary Searches**: Find row first, then column
2. **Linear Search**: O(mn) time complexity
3. **Diagonal Search**: Start from top-right corner

## Edge Cases

- Empty matrix: Return false
- Single element: Check if equals target
- Target not found: Return false
- Target at boundaries: Handle first/last elements
- Single row/column: Handle edge cases

## Applications

- Matrix operations
- Search algorithms
- Algorithm design patterns
- Interview preparation
- Database queries

## Optimization Opportunities

- **Flattened Binary Search**: Most efficient approach
- **Index Conversion**: Efficient coordinate mapping
- **Single Pass**: One binary search instead of two
- **Memory Efficient**: O(1) space complexity
