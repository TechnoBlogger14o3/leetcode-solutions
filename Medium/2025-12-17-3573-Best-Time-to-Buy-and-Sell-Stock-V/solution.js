var maxProfit = function(prices, k) {
    const n = prices.length;
    if (n === 0 || k === 0) return 0;
    
    // If k is greater than half the number of days, we can make unlimited transactions
    if (k >= n / 2) {
        let profit = 0;
        for (let i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    // DP array
    const dp = Array.from({ length: k + 1 }, () => Array(n).fill(0));

    for (let i = 1; i <= k; i++) {
        let maxDiff = -prices[0];
        for (let j = 1; j < n; j++) {
            dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
            maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
        }
    }

    return dp[k][n - 1];
};