from collections import deque

class Solution:
    def canWalk(self, grid: List[List[int]], health: int) -> bool:
        m, n = len(grid), len(grid[0])
        if health <= 0 or grid[0][0] == 1:
            return False
        
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        queue = deque([(0, 0, health)])
        visited = set((0, 0))
        
        while queue:
            x, y, h = queue.popleft()
            if x == m - 1 and y == n - 1:
                return True
            
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n:
                    new_health = h - grid[nx][ny]
                    if new_health > 0 and (nx, ny) not in visited:
                        visited.add((nx, ny))
                        queue.append((nx, ny, new_health))
        
        return False