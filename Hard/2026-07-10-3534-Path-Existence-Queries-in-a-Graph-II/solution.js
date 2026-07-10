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
    const edges = [];
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            if (Math.abs(nums[i] - nums[j]) <= maxDiff) {
                edges.push([i, j]);
            }
        }
    }

    const results = [];
    const uf = new UnionFind(n);
    edges.sort((a, b) => Math.abs(nums[a[0]] - nums[a[1]]) - Math.abs(nums[b[0]] - nums[b[1]]));

    const queryResults = Array(queries.length).fill(-1);
    const indexedQueries = queries.map((query, index) => [...query, index]);
    indexedQueries.sort((a, b) => Math.abs(nums[a[0]] - nums[a[1]]) - Math.abs(nums[b[0]] - nums[b[1]]));

    let edgeIndex = 0;
    for (const [u, v, queryIndex] of indexedQueries) {
        while (edgeIndex < edges.length && Math.abs(nums[edges[edgeIndex][0]] - nums[edges[edgeIndex][1]]) <= maxDiff) {
            uf.union(edges[edgeIndex][0], edges[edgeIndex][1]);
            edgeIndex++;
        }
        if (uf.find(u) === uf.find(v)) {
            queryResults[queryIndex] = 1; // Path exists
        } else {
            queryResults[queryIndex] = -1; // No path
        }
    }

    return queryResults;
};