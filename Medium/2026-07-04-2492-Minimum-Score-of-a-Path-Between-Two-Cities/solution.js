class UnionFind {
    constructor(size) {
        this.parent = Array.from({ length: size }, (_, i) => i);
        this.rank = Array(size).fill(1);
    }

    find(x) {
        if (this.parent[x] !== x) {
            this.parent[x] = this.find(this.parent[x]);
        }
        return this.parent[x];
    }

    union(x, y) {
        const rootX = this.find(x);
        const rootY = this.find(y);
        if (rootX !== rootY) {
            if (this.rank[rootX] > this.rank[rootY]) {
                this.parent[rootY] = rootX;
            } else if (this.rank[rootX] < this.rank[rootY]) {
                this.parent[rootX] = rootY;
            } else {
                this.parent[rootY] = rootX;
                this.rank[rootX]++;
            }
        }
    }
}

var minScore = function(n, roads) {
    const uf = new UnionFind(n + 1);
    let minScore = Infinity;

    for (const [a, b, distance] of roads) {
        uf.union(a, b);
    }

    const root1 = uf.find(1);
    for (const [a, b, distance] of roads) {
        if (uf.find(a) === root1 && uf.find(b) === root1) {
            minScore = Math.min(minScore, distance);
        }
    }

    return minScore;
};