class UnionFind {
    constructor(n) {
        this.parent = Array.from({ length: n }, (_, i) => i);
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
            this.parent[rootY] = rootX;
        }
    }
}

var minimumHammingDistance = function(source, target, allowedSwaps) {
    const n = source.length;
    const uf = new UnionFind(n);

    for (const [a, b] of allowedSwaps) {
        uf.union(a, b);
    }

    const groups = {};
    for (let i = 0; i < n; i++) {
        const root = uf.find(i);
        if (!groups[root]) {
            groups[root] = { source: [], target: [] };
        }
        groups[root].source.push(source[i]);
        groups[root].target.push(target[i]);
    }

    let hammingDistance = 0;
    for (const group of Object.values(groups)) {
        const sourceCount = {};
        const targetCount = {};

        for (const num of group.source) {
            sourceCount[num] = (sourceCount[num] || 0) + 1;
        }
        for (const num of group.target) {
            targetCount[num] = (targetCount[num] || 0) + 1;
        }

        let matches = 0;
        for (const num in sourceCount) {
            if (targetCount[num]) {
                matches += Math.min(sourceCount[num], targetCount[num]);
            }
        }
        hammingDistance += (group.source.length - matches);
    }

    return hammingDistance;
};