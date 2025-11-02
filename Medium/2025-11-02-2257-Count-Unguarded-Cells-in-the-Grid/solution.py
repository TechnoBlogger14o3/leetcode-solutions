class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        grid = [[0] * n for _ in range(m)]
        
        for r, c in guards:
            grid[r][c] = 1  # Mark guard positions
        for r, c in walls:
            grid[r][c] = 2  # Mark wall positions
        
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        for r in range(m):
            for c in range(n):
                if grid[r][c] == 1:  # If there's a guard
                    for dr, dc in directions:
                        nr, nc = r, c
                        while 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == 0:
                            grid[nr][nc] = 3  # Mark as guarded
                            nr += dr
                            nc += dc
        
        unguarded_count = sum(row.count(0) for row in grid)
        return unguarded_count