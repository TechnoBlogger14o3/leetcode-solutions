import heapq
from collections import defaultdict

class Solution:
    def minimumCost(self, n: int, edges: List[List[int]]) -> int:
        graph = defaultdict(list)
        for u, v, w in edges:
            graph[u].append((v, w))
            graph[v].append((u, 2 * w))  # Reversed edge with cost 2 * w
        
        min_cost = [float('inf')] * n
        min_cost[0] = 0
        pq = [(0, 0)]  # (cost, node)
        
        while pq:
            cost, node = heapq.heappop(pq)
            if cost > min_cost[node]:
                continue
            
            for neighbor, edge_cost in graph[node]:
                new_cost = cost + edge_cost
                if new_cost < min_cost[neighbor]:
                    min_cost[neighbor] = new_cost
                    heapq.heappush(pq, (new_cost, neighbor))
        
        return min_cost[n - 1] if min_cost[n - 1] != float('inf') else -1