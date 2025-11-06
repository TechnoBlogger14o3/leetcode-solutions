class UnionFind {
    constructor(size) {
        this.parent = Array.from({ length: size }, (_, i) => i);
        this.rank = Array(size).fill(1);
        this.online = Array(size).fill(true);
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

    setOffline(x) {
        this.online[x] = false;
    }

    getMinOnlineInComponent(x) {
        const root = this.find(x);
        let minId = -1;
        for (let i = 0; i < this.online.length; i++) {
            if (this.find(i) === root && this.online[i]) {
                minId = minId === -1 ? i : Math.min(minId, i);
            }
        }
        return minId + 1; // Convert to 1-based index
    }
}

var maintenanceCheck = function(c, connections, queries) {
    const uf = new UnionFind(c);
    for (const [u, v] of connections) {
        uf.union(u - 1, v - 1);
    }
    
    const result = [];
    for (const [type, x] of queries) {
        const station = x - 1; // Convert to 0-based index
        if (type === 1) {
            const minOnline = uf.getMinOnlineInComponent(station);
            result.push(minOnline);
        } else if (type === 2) {
            uf.setOffline(station);
        }
    }
    
    return result;
};