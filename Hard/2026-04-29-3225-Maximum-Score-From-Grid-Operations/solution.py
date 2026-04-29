class Solution:
    def maximumScore(self, grid: List[List[int]]) -> int:
        n = len(grid)
        max_score = 0
        
        for j in range(n):
            max_row_value = 0
            for i in range(n):
                if grid[i][j] > max_row_value:
                    max_row_value = grid[i][j]
                max_score += max_row_value
        
        return max_score