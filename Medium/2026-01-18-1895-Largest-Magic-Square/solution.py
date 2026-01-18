class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[0] * n for _ in range(m)]
        max_size = 1
        
        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    dp[i][j] = 1
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                
                size = dp[i][j]
                if size > max_size:
                    if self.isMagicSquare(grid, i, j, size):
                        max_size = size
        
        return max_size
    
    def isMagicSquare(self, grid: List[List[int]], row: int, col: int, size: int) -> bool:
        target_sum = sum(grid[row][col:col + size])
        
        for i in range(size):
            if sum(grid[row + i][col:col + size]) != target_sum:
                return False
            if sum(grid[row + j][col + i] for j in range(size)) != target_sum:
                return False
        
        if sum(grid[row + i][col + i] for i in range(size)) != target_sum:
            return False
        if sum(grid[row + i][col + size - 1 - i] for i in range(size)) != target_sum:
            return False
        
        return True