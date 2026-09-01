from collections import deque

class Solution:
    def minimumMoves(self, classroom: List[str], energy: int) -> int:
        m, n = len(classroom), len(classroom[0])
        start = None
        litter_positions = []
        
        for i in range(m):
            for j in range(n):
                if classroom[i][j] == 'S':
                    start = (i, j)
                elif classroom[i][j] == 'L':
                    litter_positions.append((i, j))
        
        litter_count = len(litter_positions)
        if litter_count == 0:
            return 0
        
        def bfs(start, energy):
            queue = deque([(start[0], start[1], energy, 0)])  # (x, y, remaining_energy, moves)
            visited = set()
            visited.add((start[0], start[1], energy))
            distances = {}
            
            while queue:
                x, y, rem_energy, moves = queue.popleft()
                
                if (x, y) in litter_positions:
                    distances[(x, y)] = moves
                
                for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                    nx, ny = x + dx, y + dy
                    
                    if 0 <= nx < m and 0 <= ny < n:
                        cell = classroom[nx][ny]
                        if cell == 'X':
                            continue
                        new_energy = rem_energy - 1
                        if cell == 'R':
                            new_energy = energy
                        
                        if new_energy >= 0 and (nx, ny, new_energy) not in visited:
                            visited.add((nx, ny, new_energy))
                            queue.append((nx, ny, new_energy, moves + 1))
            
            return distances
        
        distances = bfs(start, energy)
        if len(distances) < litter_count:
            return -1
        
        from itertools import permutations
        
        min_moves = float('inf')
        for perm in permutations(litter_positions):
            total_moves = 0
            current_pos = start
            current_energy = energy
            
            for litter in perm:
                dist = bfs(current_pos, current_energy)
                if litter not in dist:
                    total_moves = float('inf')
                    break
                total_moves += dist[litter]
                current_pos = litter
                current_energy = energy  # Reset energy after collecting litter
            
            min_moves = min(min_moves, total_moves)
        
        return min_moves if min_moves != float('inf') else -1