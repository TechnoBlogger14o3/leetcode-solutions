class Solution:
    def getBiggestThree(self, grid: List[List[int]]) -> List[int]:
        m, n = len(grid), len(grid[0])
        rhombus_sums = set()

        def add_rhombus_sum(x, y, d):
            total = 0
            for i in range(d + 1):
                total += grid[x + i][y]  # top
                total += grid[x + d][y - i]  # left
                total += grid[x + d][y + i]  # right
                total += grid[x + d + i][y]  # bottom
            total -= grid[x][y]  # center counted multiple times
            rhombus_sums.add(total)

        for i in range(m):
            for j in range(n):
                rhombus_sums.add(grid[i][j])  # area 0 rhombus
                for d in range(1, min(m, n)):
                    if i + d < m and j - d >= 0 and j + d < n:
                        add_rhombus_sum(i, j, d)

        return sorted(rhombus_sums, reverse=True)[:3]