class Solution:
    def palindromicPathQueries(self, n: int, edges: List[List[int]], s: str, queries: List[str]) -> List[bool]:
        from collections import defaultdict, deque
        
        # Build the tree
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        # Prepare for LCA and depth tracking
        parent = [-1] * n
        depth = [0] * n
        visited = [False] * n
        
        # BFS to set parent and depth
        def bfs(start):
            queue = deque([start])
            visited[start] = True
            while queue:
                node = queue.popleft()
                for neighbor in graph[node]:
                    if not visited[neighbor]:
                        visited[neighbor] = True
                        parent[neighbor] = node
                        depth[neighbor] = depth[node] + 1
                        queue.append(neighbor)
        
        bfs(0)
        
        # Function to find LCA
        def lca(u, v):
            while depth[u] > depth[v]:
                u = parent[u]
            while depth[v] > depth[u]:
                v = parent[v]
            while u != v:
                u = parent[u]
                v = parent[v]
            return u
        
        # Function to check if path can form a palindrome
        def can_form_palindrome(path_chars):
            count = defaultdict(int)
            for char in path_chars:
                count[char] += 1
            odd_count = sum(1 for c in count if count[c] % 2 == 1)
            return odd_count <= 1
        
        result = []
        s = list(s)  # Convert to list for mutability
        
        for query in queries:
            parts = query.split()
            if parts[0] == "update":
                u, c = int(parts[1]), parts[2]
                s[u] = c
            elif parts[0] == "query":
                u, v = int(parts[1]), int(parts[2])
                ancestor = lca(u, v)
                path_chars = []
                
                # Collect characters from u to ancestor
                while u != ancestor:
                    path_chars.append(s[u])
                    u = parent[u]
                # Collect characters from v to ancestor
                while v != ancestor:
                    path_chars.append(s[v])
                    v = parent[v]
                # Include the ancestor
                path_chars.append(s[ancestor])
                
                # Check if the collected characters can form a palindrome
                result.append(can_form_palindrome(path_chars))
        
        return result