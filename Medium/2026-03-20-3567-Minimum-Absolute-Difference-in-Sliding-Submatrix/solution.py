from typing import List
import sortedcontainers

class Solution:
    def minimumAbsDifference(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        ans = [[0] * (n - k + 1) for _ in range(m - k + 1)]
        
        for i in range(m - k + 1):
            for j in range(n - k + 1):
                values = sortedcontainers.SortedList()
                for x in range(i, i + k):
                    for y in range(j, j + k):
                        values.add(grid[x][y])
                
                min_diff = float('inf')
                for idx in range(1, len(values)):
                    min_diff = min(min_diff, values[idx] - values[idx - 1])
                
                ans[i][j] = min_diff if min_diff != float('inf') else 0
        
        return ans