class Solution:
    def countCompleteComponents(self, n: int, edges: List[List[int]]) -> int:
        from collections import defaultdict
        
        graph = defaultdict(set)
        for a, b in edges:
            graph[a].add(b)
            graph[b].add(a)
        
        visited = [False] * n
        
        def dfs(node):
            stack = [node]
            component = []
            while stack:
                curr = stack.pop()
                if not visited[curr]:
                    visited[curr] = True
                    component.append(curr)
                    for neighbor in graph[curr]:
                        if not visited[neighbor]:
                            stack.append(neighbor)
            return component
        
        complete_count = 0
        
        for i in range(n):
            if not visited[i]:
                component = dfs(i)
                size = len(component)
                expected_edges = size * (size - 1) // 2
                actual_edges = sum(len(graph[v]) for v in component) // 2
                if expected_edges == actual_edges:
                    complete_count += 1
        
        return complete_count