from typing import List

class Solution:
    def minimumArea(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0
        
        m, n = len(grid), len(grid[0])
        
        # Find the boundaries of all 1's
        min_row, max_row = m, -1
        min_col, max_col = n, -1
        has_ones = False
        
        # Scan the matrix to find the boundaries
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    has_ones = True
                    min_row = min(min_row, i)
                    max_row = max(max_row, i)
                    min_col = min(min_col, j)
                    max_col = max(max_col, j)
        
        # If no 1's found, return 0
        if not has_ones:
            return 0
        
        # Calculate area: (max_row - min_row + 1) * (max_col - min_col + 1)
        height = max_row - min_row + 1
        width = max_col - min_col + 1
        
        return height * width
