class Solution:
    def countIslands(self, grid: List[List[int]], k: int) -> int:
        if not grid:
            return 0
        
        m, n = len(grid), len(grid[0])
        visited = [[False] * n for _ in range(m)]
        
        def dfs(i, j):
            if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] == 0 or visited[i][j]:
                return 0
            visited[i][j] = True
            total = grid[i][j]
            total += dfs(i + 1, j)
            total += dfs(i - 1, j)
            total += dfs(i, j + 1)
            total += dfs(i, j - 1)
            return total
        
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] > 0 and not visited[i][j]:
                    island_value = dfs(i, j)
                    if island_value % k == 0:
                        count += 1
        
        return count