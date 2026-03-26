class Solution:
    def equalSumGridPartition(self, grid: List[List[int]]) -> bool:
        m, n = len(grid), len(grid[0])
        
        def prefix_sum(grid):
            ps = [[0] * (n + 1) for _ in range(m + 1)]
            for i in range(1, m + 1):
                for j in range(1, n + 1):
                    ps[i][j] = grid[i - 1][j - 1] + ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1]
            return ps
        
        ps = prefix_sum(grid)
        total_sum = ps[m][n]
        
        # Check horizontal cuts
        for i in range(1, m):
            top_sum = ps[i][n]
            bottom_sum = total_sum - top_sum
            if top_sum == bottom_sum:
                return True
            if top_sum > bottom_sum:
                if (top_sum - bottom_sum) in (grid[i][j] for j in range(n)):
                    return True
        
        # Check vertical cuts
        for j in range(1, n):
            left_sum = ps[m][j]
            right_sum = total_sum - left_sum
            if left_sum == right_sum:
                return True
            if left_sum > right_sum:
                if (left_sum - right_sum) in (grid[i][j] for i in range(m)):
                    return True
        
        return False