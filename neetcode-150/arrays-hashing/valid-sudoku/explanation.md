# Valid Sudoku

## Problem Statement

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

1. Each row must contain the digits 1-9 without repetition.
2. Each column must contain the digits 1-9 without repetition.
3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

**Note:**
- A Sudoku board (partially filled) could be valid but is not necessarily solvable.
- Only the filled cells need to be validated according to the mentioned rules.

## Examples

**Example 1:**
```
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
```

## Approach

### Method 1: Three Sets (Recommended)
1. Use three sets to track numbers in rows, columns, and 3x3 boxes
2. For each cell, check if the number already exists in its row, column, or box
3. If found, return false; otherwise add to all three sets

**Time Complexity:** O(1) - Fixed 9x9 grid, constant time
**Space Complexity:** O(1) - Fixed number of sets

### Method 2: Single Pass with String Keys
1. Use a single set with string keys for row, column, and box
2. Format: "row-5", "col-3", "box-0-0"
3. Check for duplicates in single pass

**Time Complexity:** O(1) - Fixed 9x9 grid
**Space Complexity:** O(1) - Single set

## Algorithm

```
1. Initialize three sets: rows, columns, boxes
2. For each cell (i, j) in the board:
   a. If cell is empty ('.'), skip
   b. Calculate box index: (i/3) * 3 + (j/3)
   c. Create keys for row, column, and box
   d. If any key exists in sets:
      - Return false
   e. Else:
      - Add keys to respective sets
3. Return true (no duplicates found)
```

## Key Insights

- **Box Index Calculation**: (row/3) * 3 + (col/3) gives box number
- **Three Constraints**: Must check row, column, and box simultaneously
- **Empty Cells**: Skip validation for '.' characters
- **Single Pass**: Can validate all constraints in one iteration

## Alternative Approaches

1. **Separate Validation**: Check rows, then columns, then boxes separately
2. **Bit Manipulation**: Use bit masks for tracking (more memory efficient)
3. **Array Tracking**: Use boolean arrays instead of sets

## Edge Cases

- Empty board: Valid (no constraints violated)
- Partially filled: Only validate filled cells
- All empty: Valid
- Single filled cell: Valid
- Invalid row/column/box: Return false immediately

## Applications

- Sudoku game validation
- Constraint satisfaction problems
- Puzzle solving algorithms
- Data validation systems
- Game development

## Optimization Opportunities

- **Early Exit**: Return false as soon as duplicate found
- **Bit Manipulation**: Use bit masks for memory efficiency
- **Single Set**: Use string keys to combine all constraints
- **In-place**: Validate without extra data structures
