class Solution {
    numberOfWays(edges) {
        const MOD = 1e9 + 7;
        const graph = new Map();
        
        for (const [u, v] of edges) {
            if (!graph.has(u)) graph.set(u, []);
            if (!graph.has(v)) graph.set(v, []);
            graph.get(u).push(v);
            graph.get(v).push(u);
        }
        
        let maxDepth = 0;
        let countAtMaxDepth = 0;
        
        const dfs = (node, parent, depth) => {
            if (depth > maxDepth) {
                maxDepth = depth;
                countAtMaxDepth = 1;
            } else if (depth === maxDepth) {
                countAtMaxDepth++;
            }
            
            for (const neighbor of graph.get(node)) {
                if (neighbor !== parent) {
                    dfs(neighbor, node, depth + 1);
                }
            }
        };
        
        dfs(1, -1, 0);
        
        return countAtMaxDepth === 0 ? 0 : (countAtMaxDepth * (1 << (maxDepth - 1))) % MOD;
    }
}