class Solution {
    maxScore(edges, online, k) {
        const n = online.length;
        const graph = Array.from({ length: n }, () => []);
        
        for (const [u, v, cost] of edges) {
            graph[u].push({ v, cost });
        }
        
        const bfs = (minEdgeCost) => {
            const queue = [{ node: 0, totalCost: 0 }];
            const visited = new Set();
            visited.add(0);
            
            while (queue.length) {
                const { node, totalCost } = queue.shift();
                
                if (node === n - 1) return true;
                
                for (const { v, cost } of graph[node]) {
                    if (online[v] && !visited.has(v) && totalCost + cost <= k && cost >= minEdgeCost) {
                        visited.add(v);
                        queue.push({ node: v, totalCost: totalCost + cost });
                    }
                }
            }
            return false;
        };
        
        let left = 0, right = Math.max(...edges.map(edge => edge[2])), result = -1;
        
        while (left <= right) {
            const mid = Math.floor((left + right) / 2);
            if (bfs(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}