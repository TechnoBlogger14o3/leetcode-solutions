class UnionFind {
    constructor(n) {
        this.parent = Array.from({ length: n }, (_, i) => i);
        this.rank = Array(n).fill(1);
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
            return true;
        }
        return false;
    }
}

function maximizeStability(n, edges, k) {
    const mustEdges = [];
    const optionalEdges = [];

    for (const [u, v, s, must] of edges) {
        if (must === 1) {
            mustEdges.push([u, v, s]);
        } else {
            optionalEdges.push([u, v, s]);
        }
    }

    const uf = new UnionFind(n);
    let minStrength = Infinity;

    for (const [u, v, s] of mustEdges) {
        if (!uf.union(u, v)) {
            return -1; // Cycle detected
        }
        minStrength = Math.min(minStrength, s);
    }

    optionalEdges.sort((a, b) => b[2] - a[2]);
    const upgrades = [];

    for (const [u, v, s] of optionalEdges) {
        if (uf.union(u, v)) {
            minStrength = Math.min(minStrength, s);
        } else {
            upgrades.push(s);
        }
    }

    if (upgrades.length + mustEdges.length < n - 1) {
        return -1; // Not enough edges to connect all nodes
    }

    upgrades.sort((a, b) => b - a);
    let maxStability = minStrength;

    for (let i = 0; i < Math.min(k, upgrades.length); i++) {
        maxStability = Math.max(maxStability, upgrades[i] * 2);
    }

    return maxStability;
}