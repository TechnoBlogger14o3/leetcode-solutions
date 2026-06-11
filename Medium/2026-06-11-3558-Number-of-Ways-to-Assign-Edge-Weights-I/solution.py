class Solution:
    def numberOfWays(self, edges: List[List[int]]) -> int:
        from collections import defaultdict, deque
        
        MOD = 10**9 + 7
        
        # Build the tree
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        # BFS to find maximum depth and count nodes at that depth
        max_depth = 0
        depth_count = defaultdict(int)
        queue = deque([(1, 0)])  # (node, depth)
        visited = set([1])
        
        while queue:
            node, depth = queue.popleft()
            depth_count[depth] += 1
            max_depth = max(max_depth, depth)
            
            for neighbor in graph[node]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append((neighbor, depth + 1))
        
        # Number of edges in the path to the deepest nodes
        num_edges = max_depth
        
        # Calculate the number of ways to assign weights
        if num_edges == 0:
            return 0
        
        # We need to find the number of ways to make the total weight odd
        # If num_edges is odd, we can have odd sums with (1, 2) combinations
        # If num_edges is even, we can have odd sums with (2, 1) combinations
        if num_edges % 2 == 0:
            return pow(2, num_edges - 1, MOD) % MOD
        else:
            return pow(2, num_edges - 1, MOD) % MOD

# Example usage:
# sol = Solution()
# print(sol.numberOfWays([[1,2]]))  # Output: 1
# print(sol.numberOfWays([[1,2],[1,3],[3,4],[3,5]]))  # Output: 2