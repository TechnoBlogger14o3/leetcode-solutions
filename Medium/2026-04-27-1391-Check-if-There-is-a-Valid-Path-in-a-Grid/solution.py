class Solution:
    def hasValidPath(self, grid: List[List[int]]) -> bool:
        m, n = len(grid), len(grid[0])
        directions = {
            1: [(0, 1), (0, -1)],
            2: [(1, 0), (-1, 0)],
            3: [(0, 1), (1, 0)],
            4: [(0, 1), (-1, 0)],
            5: [(0, -1), (1, 0)],
            6: [(0, -1), (-1, 0)]
        }
        connect = {
            (0, 1): (0, -1),
            (0, -1): (0, 1),
            (1, 0): (-1, 0),
            (-1, 0): (1, 0)
        }
        
        def is_valid(x, y):
            return 0 <= x < m and 0 <= y < n
        
        visited = set()
        stack = [(0, 0)]
        
        while stack:
            x, y = stack.pop()
            if (x, y) in visited:
                continue
            visited.add((x, y))
            if x == m - 1 and y == n - 1:
                return True
            
            for dx, dy in directions[grid[x][y]]:
                nx, ny = x + dx, y + dy
                if is_valid(nx, ny) and (dx, dy) in connect and connect[(dx, dy)] in directions[grid[nx][ny]]:
                    stack.append((nx, ny))
        
        return False