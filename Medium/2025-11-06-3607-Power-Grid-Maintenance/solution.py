class UnionFind:
    def __init__(self, size):
        self.parent = list(range(size))
        self.rank = [1] * size
        self.online = [True] * size

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x, y):
        rootX = self.find(x)
        rootY = self.find(y)
        if rootX != rootY:
            if self.rank[rootX] > self.rank[rootY]:
                self.parent[rootY] = rootX
            elif self.rank[rootX] < self.rank[rootY]:
                self.parent[rootX] = rootY
            else:
                self.parent[rootY] = rootX
                self.rank[rootX] += 1

    def set_offline(self, x):
        self.online[x] = False

    def get_min_online(self, x):
        root = self.find(x)
        min_online = float('inf')
        for i in range(len(self.online)):
            if self.find(i) == root and self.online[i]:
                min_online = min(min_online, i)
        return min_online if min_online != float('inf') else -1


class Solution:
    def maintenance(self, c: int, connections: List[List[int]], queries: List[List[int]]) -> List[int]:
        uf = UnionFind(c + 1)
        
        for u, v in connections:
            uf.union(u - 1, v - 1)

        result = []
        
        for query in queries:
            if query[0] == 1:
                x = query[1] - 1
                if uf.online[x]:
                    result.append(x + 1)
                else:
                    result.append(uf.get_min_online(x))
            elif query[0] == 2:
                x = query[1] - 1
                uf.set_offline(x)

        return result