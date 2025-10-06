import heapq

class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        min_heap = [(grid[0][0], 0, 0)]
        visited = set((0, 0))
        
        while min_heap:
            t, x, y = heapq.heappop(min_heap)
            if (x, y) == (n - 1, n - 1):
                return t
            
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < n and (nx, ny) not in visited:
                    visited.add((nx, ny))
                    heapq.heappush(min_heap, (max(t, grid[nx][ny]), nx, ny))