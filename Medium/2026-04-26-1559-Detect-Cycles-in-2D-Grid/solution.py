class Solution:
    def containsCycle(self, grid: List[List[str]]) -> bool:
        m, n = len(grid), len(grid[0])
        visited = [[False] * n for _ in range(m)]
        
        def dfs(x, y, px, py, char, depth):
            if visited[x][y]:
                return depth >= 4
            
            visited[x][y] = True
            for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] == char:
                    if (nx, ny) != (px, py):
                        if dfs(nx, ny, x, y, char, depth + 1):
                            return True
            visited[x][y] = False
            return False
        
        for i in range(m):
            for j in range(n):
                if not visited[i][j]:
                    if dfs(i, j, -1, -1, grid[i][j], 0):
                        return True
        return False