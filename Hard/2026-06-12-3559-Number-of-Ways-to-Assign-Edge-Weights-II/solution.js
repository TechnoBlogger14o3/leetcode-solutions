class Solution {
    constructor() {
        this.MOD = 1e9 + 7;
    }

    numberOfWays(edges, queries) {
        const n = edges.length + 1;
        const graph = Array.from({ length: n + 1 }, () => []);
        for (const [u, v] of edges) {
            graph[u].push(v);
            graph[v].push(u);
        }

        const depth = Array(n + 1).fill(0);
        const parent = Array(n + 1).fill(0);
        const dfs = (node, par, d) => {
            parent[node] = par;
            depth[node] = d;
            for (const neighbor of graph[node]) {
                if (neighbor !== par) {
                    dfs(neighbor, node, d + 1);
                }
            }
        };

        dfs(1, -1, 0);

        const findLCA = (u, v) => {
            while (u !== v) {
                if (depth[u] > depth[v]) {
                    u = parent[u];
                } else {
                    v = parent[v];
                }
            }
            return u;
        };

        const answer = [];
        for (const [u, v] of queries) {
            const lca = findLCA(u, v);
            const pathLength = depth[u] + depth[v] - 2 * depth[lca];
            const oddCount = Math.floor(pathLength / 2);
            const evenCount = Math.ceil(pathLength / 2);
            const ways = (this.modPow(2, oddCount) * this.modPow(2, evenCount)) % this.MOD;
            answer.push(ways);
        }

        return answer;
    }

    modPow(base, exp) {
        let result = 1;
        while (exp > 0) {
            if (exp % 2 === 1) {
                result = (result * base) % this.MOD;
            }
            base = (base * base) % this.MOD;
            exp = Math.floor(exp / 2);
        }
        return result;
    }
}