import heapq
from collections import defaultdict, deque

class Solution:
    def shortestPath(self, n: int, edges: List[List[int]], labels: str, k: int) -> int:
        graph = defaultdict(list)
        for u, v, w in edges:
            graph[u].append((v, w))
        
        # Priority queue for Dijkstra's algorithm
        pq = [(0, 0, 0, '')]  # (cost, current_node, count_of_consecutive, last_label)
        visited = {}
        
        while pq:
            cost, node, count, last_label = heapq.heappop(pq)
            
            if node == n - 1:
                return cost
            
            state = (node, count, last_label)
            if state in visited and visited[state] <= cost:
                continue
            visited[state] = cost
            
            for neighbor, weight in graph[node]:
                current_label = labels[neighbor]
                new_count = count + 1 if current_label == last_label else 1
                
                if new_count <= k:
                    heapq.heappush(pq, (cost + weight, neighbor, new_count, current_label))
        
        return -1