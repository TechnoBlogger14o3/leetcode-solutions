import heapq

class Solution:
    def minCost(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        directions = [(0, 1), (1, 0)]
        min_cost = [[float('inf')] * (k + 1) for _ in range(m)]
        min_cost[0][0] = 0
        pq = [(0, 0, 0)]  # (cost, x, y)

        while pq:
            cost, x, y = heapq.heappop(pq)

            if (x, y) == (m - 1, n - 1):
                return cost

            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n:
                    new_cost = cost + grid[nx][ny]
                    if new_cost < min_cost[nx][ny]:
                        min_cost[nx][ny] = new_cost
                        heapq.heappush(pq, (new_cost, nx, ny))

            if k > 0:
                for i in range(m):
                    for j in range(n):
                        if grid[i][j] <= grid[x][y]:
                            if cost < min_cost[i][j]:
                                min_cost[i][j] = cost
                                heapq.heappush(pq, (cost, i, j))

        return -1