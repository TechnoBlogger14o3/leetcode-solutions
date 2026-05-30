class BlockPlacementQueries {
    constructor() {
        this.obstacles = new Set();
    }

    canPlaceBlock(x, sz) {
        let start = 0;
        for (let obs of this.obstacles) {
            if (obs > x) break;
            if (obs - start >= sz) return true;
            start = obs;
        }
        return x - start >= sz;
    }

    handleQueries(queries) {
        const results = [];
        for (const query of queries) {
            if (query[0] === 1) {
                this.obstacles.add(query[1]);
            } else {
                results.push(this.canPlaceBlock(query[1], query[2]));
            }
        }
        return results;
    }
}

var blockPlacementQueries = function(queries) {
    const bpq = new BlockPlacementQueries();
    return bpq.handleQueries(queries);
};