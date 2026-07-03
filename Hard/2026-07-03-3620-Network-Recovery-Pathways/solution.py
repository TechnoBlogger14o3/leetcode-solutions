from collections import defaultdict
import heapq

class Solution:
    def maximumPathScore(self, edges: List[List[int]], online: List[bool], k: int) -> int:
        graph = defaultdict(list)
        for u, v, cost in edges:
            graph[u].append((v, cost))
        
        n = len(online)
        max_score = -1
        
        def canReach(min_cost):
            pq = [(0, 0)]  # (total_cost, node)
            costs = [float('inf')] * n
            costs[0] = 0
            
            while pq:
                total_cost, node = heapq.heappop(pq)
                if node == n - 1:
                    return total_cost <= k
                for neighbor, cost in graph[node]:
                    if online[neighbor] and cost >= min_cost:
                        new_cost = total_cost + cost
                        if new_cost < costs[neighbor]:
                            costs[neighbor] = new_cost
                            heapq.heappush(pq, (new_cost, neighbor))
            return False
        
        left, right = 0, max(cost for _, _, cost in edges)
        while left <= right:
            mid = (left + right) // 2
            if canReach(mid):
                max_score = mid
                left = mid + 1
            else:
                right = mid - 1
        
        return max_score