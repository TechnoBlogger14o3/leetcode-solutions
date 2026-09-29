class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        m, n = len(grid), len(grid[0])
        visited = set()
        
        def dfs(x, y, balance):
            if (x, y, balance) in visited:
                return False
            if x == m - 1 and y == n - 1:
                return balance == 0
            visited.add((x, y, balance))
            if grid[x][y] == '(':
                balance += 1
            else:
                balance -= 1
            
            if balance < 0:
                return False
            
            if x + 1 < m and dfs(x + 1, y, balance):
                return True
            if y + 1 < n and dfs(x, y + 1, balance):
                return True
            
            visited.remove((x, y, balance))
            return False
        
        return dfs(0, 0, 0)