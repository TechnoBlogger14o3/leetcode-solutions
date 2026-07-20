class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        k = k % (m * n)
        flat_grid = [num for row in grid for num in row]
        flat_grid = flat_grid[-k:] + flat_grid[:-k]
        return [flat_grid[i * n:(i + 1) * n] for i in range(m)]