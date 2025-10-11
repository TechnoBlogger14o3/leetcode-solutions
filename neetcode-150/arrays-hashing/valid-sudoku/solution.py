"""
Time Complexity: O(1) - Fixed 9x9 grid, constant time
Space Complexity: O(1) - Fixed number of sets
"""
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        seen = set()
        
        for i in range(9):
            for j in range(9):
                cell = board[i][j]
                
                if cell != '.':
                    # Create keys for row, column, and box
                    row_key = f"row-{i}-{cell}"
                    col_key = f"col-{j}-{cell}"
                    box_key = f"box-{i//3}-{j//3}-{cell}"
                    
                    # Check if any key already exists
                    if row_key in seen or col_key in seen or box_key in seen:
                        return False
                    
                    seen.add(row_key)
                    seen.add(col_key)
                    seen.add(box_key)
        
        return True

# Alternative approach using three separate sets
class SolutionThreeSets:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = set()
        columns = set()
        boxes = set()
        
        for i in range(9):
            for j in range(9):
                cell = board[i][j]
                
                if cell != '.':
                    row_key = f"{i}-{cell}"
                    col_key = f"{j}-{cell}"
                    box_key = f"{i//3}-{j//3}-{cell}"
                    
                    if row_key in rows or col_key in columns or box_key in boxes:
                        return False
                    
                    rows.add(row_key)
                    columns.add(col_key)
                    boxes.add(box_key)
        
        return True

# Using boolean arrays for tracking
class SolutionBooleanArray:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [[False] * 9 for _ in range(9)]
        columns = [[False] * 9 for _ in range(9)]
        boxes = [[False] * 9 for _ in range(9)]
        
        for i in range(9):
            for j in range(9):
                cell = board[i][j]
                
                if cell != '.':
                    num = ord(cell) - ord('1')  # Convert to 0-8 index
                    box_index = (i // 3) * 3 + (j // 3)
                    
                    if rows[i][num] or columns[j][num] or boxes[box_index][num]:
                        return False
                    
                    rows[i][num] = True
                    columns[j][num] = True
                    boxes[box_index][num] = True
        
        return True

# More concise version using any()
class SolutionConcise:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        seen = set()
        return not any(
            cell != '.' and (
                f"row-{i}-{cell}" in seen or
                f"col-{j}-{cell}" in seen or
                f"box-{i//3}-{j//3}-{cell}" in seen or
                seen.update([f"row-{i}-{cell}", f"col-{j}-{cell}", f"box-{i//3}-{j//3}-{cell}"])
            )
            for i in range(9)
            for j in range(9)
            for cell in [board[i][j]]
        )
