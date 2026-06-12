class Solution:
    def numberOfWays(self, edges: List[List[int]], queries: List[List[int]]) -> List[int]:
        from collections import defaultdict, deque
        
        MOD = 10**9 + 7
        
        # Build the tree
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        # Prepare to find parent and depth
        parent = [0] * (len(edges) + 2)
        depth = [0] * (len(edges) + 2)
        
        # BFS to establish parent and depth
        def bfs(root):
            queue = deque([root])
            visited = {root}
            while queue:
                node = queue.popleft()
                for neighbor in graph[node]:
                    if neighbor not in visited:
                        visited.add(neighbor)
                        parent[neighbor] = node
                        depth[neighbor] = depth[node] + 1
                        queue.append(neighbor)
        
        bfs(1)
        
        # Function to find the path length between two nodes
        def path_length(u, v):
            length = 0
            while u != v:
                if depth[u] > depth[v]:
                    u = parent[u]
                else:
                    v = parent[v]
                length += 1
            return length
        
        # Answer the queries
        result = []
        for u, v in queries:
            length = path_length(u, v)
            if length == 0:
                result.append(0)
            else:
                # Number of ways to assign weights such that the sum is odd
                result.append(pow(2, length - 1, MOD))
        
        return result