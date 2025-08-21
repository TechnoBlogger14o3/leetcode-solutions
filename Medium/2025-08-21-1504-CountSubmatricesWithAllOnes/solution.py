from typing import List

class Solution:
    def numSubmat(self, mat: List[List[int]]) -> int:
        if not mat or not mat[0]:
            return 0
        
        m, n = len(mat), len(mat[0])
        count = 0
        
        # For each row, calculate the number of consecutive 1s ending at each position
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    # Count submatrices ending at current position
                    count += self.count_submatrices_at(mat, i, j)
        
        return count
    
    def count_submatrices_at(self, mat: List[List[int]], row: int, col: int) -> int:
        count = 0
        max_width = float('inf')
        
        # Try different heights starting from current row
        for height in range(row + 1):
            consecutive_ones = 0
            
            # Count consecutive 1s in current row
            for j in range(col, -1, -1):
                if mat[row - height][j] == 1:
                    consecutive_ones += 1
                else:
                    break
            
            # Update maxWidth to be the minimum of all rows in current height
            max_width = min(max_width, consecutive_ones)
            
            # Add count for current height and width
            count += max_width
        
        return count
