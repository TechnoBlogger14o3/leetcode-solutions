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

var distanceLimitedPathsExist = function(n, nums, maxDiff, queries) {
    const uf = new UnionFind(n);
    const edges = [];

    for (let i = 0; i < n - 1; i++) {
        if (nums[i + 1] - nums[i] <= maxDiff) {
            uf.union(i, i + 1);
        }
    }

    const results = [];
    for (const [u, v] of queries) {
        results.push(uf.find(u) === uf.find(v));
    }

    return results;
};