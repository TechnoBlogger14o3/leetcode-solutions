class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        def isMagicSquare(x, y):
            nums = {grid[x+i][y+j] for i in range(3) for j in range(3)}
            if nums != {1, 2, 3, 4, 5, 6, 7, 8, 9}:
                return False
            return (grid[x][y] + grid[x][y+1] + grid[x][y+2] == 
                    grid[x+1][y] + grid[x+1][y+1] + grid[x+1][y+2] == 
                    grid[x+2][y] + grid[x+2][y+1] + grid[x+2][y+2] == 
                    grid[x][y] + grid[x+1][y] + grid[x+2][y] == 
                    grid[x][y+1] + grid[x+1][y+1] + grid[x+2][y+1] == 
                    grid[x][y+2] + grid[x+1][y+2] + grid[x+2][y+2] == 
                    grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2] == 
                    grid[x+2][y] + grid[x+1][y+1] + grid[x][y+2])
        
        count = 0
        rows, cols = len(grid), len(grid[0])
        for i in range(rows - 2):
            for j in range(cols - 2):
                if isMagicSquare(i, j):
                    count += 1
        return count