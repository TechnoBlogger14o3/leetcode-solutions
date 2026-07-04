from collections import defaultdict, deque

class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        graph = defaultdict(list)
        
        for a, b, distance in roads:
            graph[a].append((b, distance))
            graph[b].append((a, distance))
        
        min_score = float('inf')
        visited = set()
        queue = deque([1])
        visited.add(1)
        
        while queue:
            city = queue.popleft()
            for neighbor, distance in graph[city]:
                min_score = min(min_score, distance)
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)
        
        return min_score