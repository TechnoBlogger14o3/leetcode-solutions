from typing import List

class Solution:
    
    def boundingBoxArea(self, grid: List[List[int]], u: int, d: int, l: int, r: int) -> int:
        min_row, max_row = len(grid), -1
        min_col, max_col = len(grid[0]), -1

        for i in range(u, d + 1):
            for j in range(l, r + 1):
                if grid[i][j] == 1:
                    min_row = min(min_row, i)
                    max_row = max(max_row, i)
                    min_col = min(min_col, j)
                    max_col = max(max_col, j)
        
        # If no 1's is found, return "infinite" cost so this partition is invalid
        if max_row == -1:
            return float('inf')
        
        return (max_row - min_row + 1) * (max_col - min_col + 1)

    def solve(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        best = n * m
        
        # Case 1: L- shaped partitions
        for row in range(n - 1):
            for col in range(m - 1):
                # Top + Bottom - left + Bottom - right
                area1 = (self.boundingBoxArea(grid, 0, row, 0, m - 1) + 
                         self.boundingBoxArea(grid, row + 1, n - 1, 0, col) +
                         self.boundingBoxArea(grid, row + 1, n - 1, col + 1, m - 1))

                # top-left + top-right + bottom
                area2 = (self.boundingBoxArea(grid, 0, row, 0, col) + 
                         self.boundingBoxArea(grid, 0, row, col + 1, m - 1) +
                         self.boundingBoxArea(grid, row + 1, n - 1, 0, m - 1))

                best = min(best, min(area1, area2))

        # Case 2: Three horizontal strips
        for r1 in range(n - 2):
            for r2 in range(r1 + 1, n - 1):
                area = (self.boundingBoxArea(grid, 0, r1, 0, m - 1) + 
                        self.boundingBoxArea(grid, r1 + 1, r2, 0, m - 1) +
                        self.boundingBoxArea(grid, r2 + 1, n - 1, 0, m - 1))
                best = min(best, area)
        
        return best

    def rotate90(self, grid: List[List[int]]) -> List[List[int]]:
        n, m = len(grid), len(grid[0])
        rotated = [[0] * n for _ in range(m)]

        for i in range(n):
            for j in range(m):
                rotated[j][n - 1 - i] = grid[i][j]
        
        return rotated

    def minimumSum(self, grid: List[List[int]]) -> int:
        rotated = self.rotate90(grid)
        return min(self.solve(grid), self.solve(rotated))
