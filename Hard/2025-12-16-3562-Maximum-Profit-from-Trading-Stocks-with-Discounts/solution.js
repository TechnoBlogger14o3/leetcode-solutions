class Solution {
    maxProfit(n, present, future, hierarchy, budget) {
        const graph = Array.from({ length: n + 1 }, () => []);
        for (const [u, v] of hierarchy) {
            graph[u].push(v);
        }

        const dp = Array.from({ length: budget + 1 }, () => 0);

        const dfs = (employee) => {
            const costs = [];
            const profits = [];
            costs.push(present[employee - 1]);
            profits.push(future[employee - 1] - present[employee - 1]);

            for (const subordinate of graph[employee]) {
                const [subCost, subProfit] = dfs(subordinate);
                costs.push(Math.floor(present[subordinate - 1] / 2));
                profits.push(future[subordinate - 1] - Math.floor(present[subordinate - 1] / 2));
            }

            const newDp = [...dp];
            for (let i = budget; i >= 0; i--) {
                for (let j = 0; j < costs.length; j++) {
                    if (i >= costs[j]) {
                        newDp[i] = Math.max(newDp[i], dp[i - costs[j]] + profits[j]);
                    }
                }
            }
            return [costs, profits];
        };

        dfs(1);
        return Math.max(...dp);
    }
}