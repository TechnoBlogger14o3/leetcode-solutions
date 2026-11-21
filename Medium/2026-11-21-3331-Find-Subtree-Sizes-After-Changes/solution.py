class Solution:
    def subtreeSizes(self, parent: List[int], s: str) -> List[int]:
        n = len(parent)
        tree = [[] for _ in range(n)]
        for i in range(1, n):
            tree[parent[i]].append(i)
        
        answer = [0] * n
        size = [0] * n
        
        def dfs(node: int) -> int:
            count = 1
            for child in tree[node]:
                count += dfs(child)
            size[node] = count
            return count
        
        dfs(0)
        
        new_parent = [-1] * n
        for x in range(1, n):
            y = x
            while y != -1 and s[y] != s[x]:
                y = parent[y]
            if y != -1:
                new_parent[x] = y
        
        new_tree = [[] for _ in range(n)]
        for x in range(1, n):
            if new_parent[x] != -1:
                new_tree[new_parent[x]].append(x)
        
        def new_dfs(node: int) -> int:
            count = 1
            for child in new_tree[node]:
                count += new_dfs(child)
            answer[node] = count
            return count
        
        new_dfs(0)
        return answer