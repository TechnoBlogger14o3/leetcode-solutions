# Sudoku Solver (Hard)

**Problem ID:** 37  
**Date:** 2025-08-31  
**Link:** https://leetcode.com/problems/sudoku-solver/

## Approach

To solve the Sudoku Solver problem, we employ a backtracking approach, which is a systematic way to explore all potential configurations of the Sudoku board until a valid solution is found.

### Main Idea:
The core idea is to fill the empty cells (denoted by '.') one by one, ensuring that each placement adheres to the Sudoku rules: each digit (1-9) must appear exactly once in each row, column, and 3x3 sub-box. If we reach a point where no valid number can be placed, we backtrack to the previous cell and try a different number.

### Approach:
1. **Backtracking Function**: Create a recursive function that attempts to fill the board. This function will:
   - Search for the next empty cell.
   - For each number from 1 to 9, check if placing that number is valid.
   - If valid, place the number and recursively call the function to fill the next empty cell.
   - If placing the number leads to a solution, return true. If not, reset the cell (backtrack) and try the next number.
   - If no numbers are valid, return false to backtrack further.

2. **Validation Function**: Implement a helper function to validate whether a number can be placed in a specific cell by checking:
   - The corresponding row for duplicates.
   - The corresponding column for duplicates.
   - The corresponding 3x3 sub-box for duplicates.

### Data Structures:
- The board is represented as a 2D array (list of lists) of strings.
- The validation checks can be efficiently done using simple loops or sets to track used numbers.

### Complexity:
- **Time Complexity**: The worst-case scenario involves trying every possible number in every empty cell, leading to a complexity of O(9^(n^2)), where n is the size of the board (9 in this case). However, due to the constraints and the nature of Sudoku, the average case is much better, often closer to O(1) for practical inputs.
- **Space Complexity**: O(n^2) for the recursion stack in the worst case, where n is the size of the board (again, 9).

By using backtracking, we can efficiently navigate through the possible configurations and arrive at the unique solution guaranteed by the problem constraints.
