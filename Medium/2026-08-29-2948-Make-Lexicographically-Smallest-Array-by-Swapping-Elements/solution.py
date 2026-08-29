class Solution:
    def smallestArray(self, nums: List[int], limit: int) -> List[int]:
        n = len(nums)
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

        for i in range(n):
            for j in range(i + 1, n):
                if abs(nums[i] - nums[j]) <= limit:
                    union(i, j)

        groups = {}
        for i in range(n):
            root = find(i)
            if root not in groups:
                groups[root] = []
            groups[root].append(nums[i])

        result = [0] * n
        for indices in groups.values():
            indices.sort()
            for idx, value in zip(sorted(groups.keys()), indices):
                result[idx] = value

        return result