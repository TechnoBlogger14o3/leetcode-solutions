class Solution {
    minimumCost(source, target, original, changed, cost) {
        const n = source.length;
        const m = original.length;
        const dp = Array(n + 1).fill(Infinity);
        dp[0] = 0;

        const map = new Map();
        for (let i = 0; i < m; i++) {
            const key = original[i];
            if (!map.has(key)) {
                map.set(key, []);
            }
            map.get(key).push([changed[i], cost[i]]);
        }

        for (let i = 0; i < n; i++) {
            if (dp[i] === Infinity) continue;

            for (let j = i; j < n; j++) {
                const sub = source.slice(i, j + 1);
                if (sub === target.slice(i, j + 1)) {
                    dp[j + 1] = Math.min(dp[j + 1], dp[i]);
                } else if (map.has(sub)) {
                    for (const [newSub, c] of map.get(sub)) {
                        const newTarget = target.slice(0, i) + newSub + target.slice(j + 1);
                        if (newTarget === target) {
                            dp[j + 1] = Math.min(dp[j + 1], dp[i] + c);
                        }
                    }
                }
            }
        }

        return dp[n] === Infinity ? -1 : dp[n];
    }
}