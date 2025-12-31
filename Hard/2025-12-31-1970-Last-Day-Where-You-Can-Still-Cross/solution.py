class Solution:
    def canCross(self, row, col, cells, day):
        grid = [[0] * col for _ in range(row)]
        for i in range(day):
            r, c = cells[i]
            grid[r - 1][c - 1] = 1
        
        visited = [[False] * col for _ in range(row)]
        queue = collections.deque()
        
        for c in range(col):
            if grid[0][c] == 0:
                queue.append((0, c))
                visited[0][c] = True
        
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        
        while queue:
            r, c = queue.popleft()
            if r == row - 1:
                return True
            
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < row and 0 <= nc < col and not visited[nr][nc] and grid[nr][nc] == 0:
                    visited[nr][nc] = True
                    queue.append((nr, nc))
        
        return False

    def latestDayToCross(self, row: int, col: int, cells: List[List[int]]) -> int:
        left, right = 1, len(cells)
        answer = 0
        
        while left <= right:
            mid = (left + right) // 2
            if self.canCross(row, col, cells, mid):
                answer = mid
                left = mid + 1
            else:
                right = mid - 1
        
        return answer