class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [1] * n

    def find(self, u):
        if self.parent[u] != u:
            self.parent[u] = self.find(self.parent[u])
        return self.parent[u]

    def union(self, u, v):
        rootU = self.find(u)
        rootV = self.find(v)
        if rootU != rootV:
            if self.rank[rootU] > self.rank[rootV]:
                self.parent[rootV] = rootU
            elif self.rank[rootU] < self.rank[rootV]:
                self.parent[rootU] = rootV
            else:
                self.parent[rootV] = rootU
                self.rank[rootU] += 1
            return True
        return False

def maxStability(n, edges, k):
    must_edges = []
    optional_edges = []
    
    for u, v, s, must in edges:
        if must == 1:
            must_edges.append((s, u, v))
        else:
            optional_edges.append((s, u, v))
    
    must_edges.sort(reverse=True, key=lambda x: x[0])
    optional_edges.sort(reverse=True, key=lambda x: x[0])
    
    uf = UnionFind(n)
    min_strength = float('inf')
    
    for s, u, v in must_edges:
        if not uf.union(u, v):
            return -1
        min_strength = min(min_strength, s)
    
    if len(must_edges) + len(optional_edges) < n - 1:
        return -1
    
    optional_edges = [(s * 2, u, v) for s, u, v in optional_edges]
    
    left, right = 0, min_strength
    answer = -1
    
    while left <= right:
        mid = (left + right) // 2
        temp_uf = UnionFind(n)
        upgrades_used = 0
        
        for s, u, v in must_edges:
            temp_uf.union(u, v)
        
        for s, u, v in optional_edges:
            if upgrades_used < k and s >= mid:
                temp_uf.union(u, v)
                upgrades_used += 1
            elif s // 2 >= mid:
                temp_uf.union(u, v)
        
        if sum(1 for i in range(n) if temp_uf.find(i) == i) == 1:
            answer = mid
            left = mid + 1
        else:
            right = mid - 1
    
    return answer