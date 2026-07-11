class Solution {
    countCompleteComponents(n, edges) {
        const graph = Array.from({ length: n }, () => []);
        const visited = new Array(n).fill(false);
        
        for (const [a, b] of edges) {
            graph[a].push(b);
            graph[b].push(a);
        }

        const dfs = (node) => {
            const stack = [node];
            const component = [];
            while (stack.length) {
                const curr = stack.pop();
                if (!visited[curr]) {
                    visited[curr] = true;
                    component.push(curr);
                    for (const neighbor of graph[curr]) {
                        if (!visited[neighbor]) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
            return component;
        };

        let completeCount = 0;

        for (let i = 0; i < n; i++) {
            if (!visited[i]) {
                const component = dfs(i);
                const size = component.length;
                const edgesCount = component.reduce((count, node) => count + graph[node].length, 0) / 2;
                if (edgesCount === (size * (size - 1)) / 2) {
                    completeCount++;
                }
            }
        }

        return completeCount;
    }
}