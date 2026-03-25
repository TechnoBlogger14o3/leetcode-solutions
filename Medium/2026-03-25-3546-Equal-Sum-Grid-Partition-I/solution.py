class Solution:
    def canPartition(self, grid: List[List[int]]) -> bool:
        m, n = len(grid), len(grid[0])
        total_sum = sum(sum(row) for row in grid)

        # Check for horizontal cut
        row_sum = 0
        for i in range(m - 1):
            row_sum += sum(grid[i])
            if row_sum * 2 == total_sum:
                return True

        # Check for vertical cut
        col_sum = [0] * n
        for j in range(n):
            for i in range(m):
                col_sum[j] += grid[i][j]

        current_sum = 0
        for j in range(n - 1):
            current_sum += col_sum[j]
            if current_sum * 2 == total_sum:
                return True

        return False