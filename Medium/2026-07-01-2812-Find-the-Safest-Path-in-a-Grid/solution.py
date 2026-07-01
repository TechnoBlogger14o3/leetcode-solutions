from collections import deque

class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        n = len(grid)
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        # BFS to calculate the minimum distance to a thief for each cell
        def bfs():
            dist = [[float('inf')] * n for _ in range(n)]
            queue = deque()
            for r in range(n):
                for c in range(n):
                    if grid[r][c] == 1:
                        dist[r][c] = 0
                        queue.append((r, c))
            while queue:
                r, c = queue.popleft()
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < n and 0 <= nc < n and dist[nr][nc] > dist[r][c] + 1:
                        dist[nr][nc] = dist[r][c] + 1
                        queue.append((nr, nc))
            return dist
        
        # Get the distance to the nearest thief for each cell
        dist_to_thief = bfs()
        
        # Binary search for the maximum safeness factor
        left, right = 0, n * 2
        while left < right:
            mid = (left + right + 1) // 2
            if self.canReachEnd(dist_to_thief, mid):
                left = mid
            else:
                right = mid - 1
        
        return left
    
    def canReachEnd(self, dist_to_thief, min_safeness):
        n = len(dist_to_thief)
        queue = deque([(0, 0)])
        visited = set((0, 0))
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        while queue:
            r, c = queue.popleft()
            if (r, c) == (n - 1, n - 1):
                return True
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < n and (nr, nc) not in visited:
                    if dist_to_thief[nr][nc] >= min_safeness:
                        visited.add((nr, nc))
                        queue.append((nr, nc))
        
        return False