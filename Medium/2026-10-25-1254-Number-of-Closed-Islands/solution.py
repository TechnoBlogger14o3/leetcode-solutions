class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        
        rows, cols = len(grid), len(grid[0])
        
        def dfs(r, c):
            if r < 0 or r >= rows or c < 0 or c >= cols:
                return False
            if grid[r][c] == 1:
                return True
            
            grid[r][c] = 1  # Mark as visited
            
            up = dfs(r - 1, c)
            down = dfs(r + 1, c)
            left = dfs(r, c - 1)
            right = dfs(r, c + 1)
            
            return up and down and left and right
        
        closed_islands = 0
        
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 0:
                    if dfs(r, c):
                        closed_islands += 1
        
        return closed_islands