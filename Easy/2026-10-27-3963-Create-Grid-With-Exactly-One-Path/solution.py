class Solution:
    def createGrid(self, m: int, n: int) -> List[str]:
        grid = [['#'] * n for _ in range(m)]
        for i in range(m):
            grid[i][0] = '.'
        for j in range(n):
            grid[m-1][j] = '.'
        grid[m-1][n-1] = '.'
        
        for i in range(m - 1):
            grid[i][1] = '.'
        for j in range(n - 1):
            grid[m - 1][j] = '.'
        
        return [''.join(row) for row in grid]