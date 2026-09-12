class Solution {
    maximumScore(intervals) {
        intervals = intervals.map((interval, index) => [...interval, index]);
        intervals.sort((a, b) => a[1] - b[1] || b[2] - a[2]);

        const n = intervals.length;
        const dp = Array.from({ length: n + 1 }, () => Array(5).fill(0));
        const prev = Array(n).fill(-1);

        for (let i = 0; i < n; i++) {
            for (let j = 0; j < i; j++) {
                if (intervals[j][1] < intervals[i][0]) {
                    prev[i] = j;
                }
            }
        }

        for (let i = 1; i <= n; i++) {
            for (let j = 1; j <= 4; j++) {
                dp[i][j] = dp[i - 1][j];
                const weight = intervals[i - 1][2];
                const index = prev[i - 1];
                if (index !== -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[index + 1][j - 1] + weight);
                } else if (j === 1) {
                    dp[i][j] = Math.max(dp[i][j], weight);
                }
            }
        }

        let maxScore = 0;
        let bestCombination = [];

        for (let j = 1; j <= 4; j++) {
            if (dp[n][j] > maxScore) {
                maxScore = dp[n][j];
            }
        }

        const findCombination = (i, j) => {
            if (j === 0) return [];
            if (i === 0) return null;

            if (dp[i][j] === dp[i - 1][j]) {
                return findCombination(i - 1, j);
            }

            const weight = intervals[i - 1][2];
            const index = prev[i - 1];
            const combination = findCombination(index + 1, j - 1);
            if (combination !== null) {
                return [...combination, intervals[i - 1][3]];
            }
            return null;
        };

        for (let j = 1; j <= 4; j++) {
            if (dp[n][j] === maxScore) {
                bestCombination = findCombination(n, j);
                break;
            }
        }

        return bestCombination.sort((a, b) => a - b);
    }
}