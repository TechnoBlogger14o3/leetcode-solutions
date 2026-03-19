class Solution:
    def countSubmatrices(self, grid: List[List[str]]) -> int:
        n, m = len(grid), len(grid[0])
        count = 0
        
        for r1 in range(n):
            for r2 in range(r1, n):
                x_count = y_count = 0
                for c in range(m):
                    if grid[r1][c] == 'X':
                        x_count += 1
                    elif grid[r1][c] == 'Y':
                        y_count += 1
                    
                    if r2 > r1:
                        for r in range(r1 + 1, r2 + 1):
                            if grid[r][c] == 'X':
                                x_count += 1
                            elif grid[r][c] == 'Y':
                                y_count += 1
                    
                    if x_count > 0 and x_count == y_count:
                        count += 1
        
        return count