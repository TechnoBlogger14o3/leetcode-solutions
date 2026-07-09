class Solution:
    def distanceLimitedPathsExist(self, n: int, nums: List[int], maxDiff: int, queries: List[List[int]]) -> List[bool]:
        parent = list(range(n))

        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        def union(x, y):
            rootX = find(x)
            rootY = find(y)
            if rootX != rootY:
                parent[rootY] = rootX

        edges = []
        for i in range(n):
            for j in range(i + 1, n):
                if abs(nums[i] - nums[j]) <= maxDiff:
                    edges.append((i, j))

        for u, v in edges:
            union(u, v)

        result = []
        for u, v in queries:
            result.append(find(u) == find(v))

        return result