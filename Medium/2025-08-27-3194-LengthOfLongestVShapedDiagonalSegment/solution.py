from typing import List

class Solution:
    def lenOfVDiagonal(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0
        
        m, n = len(grid), len(grid[0])
        max_length = 0
        
        # Check for V-shaped diagonal segments
        # A V-shape can be formed by diagonal lines that meet at a point
        
        # For each cell, check if it can be part of a V-shaped diagonal
        for i in range(m):
            for j in range(n):
                if grid[i][j] != 0:
                    # Check different V-shape orientations
                    max_length = max(max_length, self.check_v_shape(grid, i, j, m, n))
        
        return max_length
    
    def check_v_shape(self, grid: List[List[int]], start_row: int, start_col: int, m: int, n: int) -> int:
        max_length = 1  # At least the starting cell
        
        # Check V-shape pointing down-right and down-left
        for length in range(1, min(m, n)):
            # Check if we can extend the V-shape
            if (start_row + length < m and start_col + length < n and 
                start_row + length < m and start_col - length >= 0):
                
                if (grid[start_row + length][start_col + length] != 0 and 
                    grid[start_row + length][start_col - length] != 0):
                    max_length = max(max_length, 2 * length + 1)
                else:
                    break
            else:
                break
        
        # Check V-shape pointing up-right and up-left
        for length in range(1, min(m, n)):
            if (start_row - length >= 0 and start_col + length < n and 
                start_row - length >= 0 and start_col - length >= 0):
                
                if (grid[start_row - length][start_col + length] != 0 and 
                    grid[start_row - length][start_col - length] != 0):
                    max_length = max(max_length, 2 * length + 1)
                else:
                    break
            else:
                break
        
        # Check V-shape pointing down-right and up-right
        for length in range(1, min(m, n)):
            if (start_row + length < m and start_col + length < n and 
                start_row - length >= 0 and start_col + length < n):
                
                if (grid[start_row + length][start_col + length] != 0 and 
                    grid[start_row - length][start_col + length] != 0):
                    max_length = max(max_length, 2 * length + 1)
                else:
                    break
            else:
                break
        
        # Check V-shape pointing down-left and up-left
        for length in range(1, min(m, n)):
            if (start_row + length < m and start_col - length >= 0 and 
                start_row - length >= 0 and start_col - length >= 0):
                
                if (grid[start_row + length][start_col - length] != 0 and 
                    grid[start_row - length][start_col - length] != 0):
                    max_length = max(max_length, 2 * length + 1)
                else:
                    break
            else:
                break
        
        return max_length
