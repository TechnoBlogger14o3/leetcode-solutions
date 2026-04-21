class UnionFind:
    def __init__(self, size):
        self.parent = list(range(size))
    
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, x, y):
        rootX = self.find(x)
        rootY = self.find(y)
        if rootX != rootY:
            self.parent[rootY] = rootX

class Solution:
    def minimumHammingDistance(self, source: List[int], target: List[int], allowedSwaps: List[List[int]]) -> int:
        n = len(source)
        uf = UnionFind(n)
        
        for a, b in allowedSwaps:
            uf.union(a, b)
        
        groups = {}
        for i in range(n):
            root = uf.find(i)
            if root not in groups:
                groups[root] = ([], [])
            groups[root][0].append(source[i])
            groups[root][1].append(target[i])
        
        hamming_distance = 0
        for s_group, t_group in groups.values():
            s_count = Counter(s_group)
            t_count = Counter(t_group)
            for key in s_count:
                if key in t_count:
                    s_count[key] -= t_count[key]
            hamming_distance += sum(max(0, count) for count in s_count.values())
        
        return hamming_distance