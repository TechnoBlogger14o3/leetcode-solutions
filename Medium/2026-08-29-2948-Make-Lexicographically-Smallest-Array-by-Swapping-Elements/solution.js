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

var smallestArray = function(nums, limit) {
    const n = nums.length;
    const uf = new UnionFind(n);

    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            if (Math.abs(nums[i] - nums[j]) <= limit) {
                uf.union(i, j);
            }
        }
    }

    const groups = {};
    for (let i = 0; i < n; i++) {
        const root = uf.find(i);
        if (!groups[root]) {
            groups[root] = [];
        }
        groups[root].push(nums[i]);
    }

    const result = new Array(n);
    for (const group of Object.values(groups)) {
        group.sort((a, b) => a - b);
        for (let i = 0; i < group.length; i++) {
            const index = nums.indexOf(group[i]);
            result[index] = group[i];
            nums[index] = null; // Mark as used
        }
    }

    return result;
};