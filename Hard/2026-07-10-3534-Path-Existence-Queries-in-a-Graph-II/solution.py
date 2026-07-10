from collections import deque
from typing import List

class Solution:
    def minDistance(self, n: int, nums: List[int], maxDiff: int, queries: List[List[int]]) -> List[int]:
        graph = [[] for _ in range(n)]
        
        # Build the graph based on the maxDiff condition
        for i in range(n):
            for j in range(i + 1, n):
                if abs(nums[i] - nums[j]) <= maxDiff:
                    graph[i].append(j)
                    graph[j].append(i)

        def bfs(start: int, end: int) -> int:
            if start == end:
                return 0
            queue = deque([start])
            visited = {start}
            distance = 0
            
            while queue:
                distance += 1
                for _ in range(len(queue)):
                    node = queue.popleft()
                    for neighbor in graph[node]:
                        if neighbor == end:
                            return distance
                        if neighbor not in visited:
                            visited.add(neighbor)
                            queue.append(neighbor)
            return -1

        result = []
        for u, v in queries:
            result.append(bfs(u, v))
        
        return result