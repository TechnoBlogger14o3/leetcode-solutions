from collections import defaultdict, deque

class Solution:
    def removeMethods(self, n: int, k: int, invocations: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        in_degree = [0] * n
        
        for a, b in invocations:
            graph[a].append(b)
            in_degree[b] += 1
        
        # Find all suspicious methods
        suspicious = set()
        queue = deque([k])
        while queue:
            method = queue.popleft()
            if method not in suspicious:
                suspicious.add(method)
                for neighbor in graph[method]:
                    queue.append(neighbor)
        
        # Check if any suspicious method is invoked by a non-suspicious method
        can_remove = True
        for a, b in invocations:
            if a not in suspicious and b in suspicious:
                can_remove = False
                break
        
        if not can_remove:
            return list(range(n))
        
        return [i for i in range(n) if i not in suspicious]