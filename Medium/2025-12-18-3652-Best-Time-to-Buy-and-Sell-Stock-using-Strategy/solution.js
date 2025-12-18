function maxProfit(prices, strategy, k) {
    const n = prices.length;
    let originalProfit = 0;

    // Calculate original profit
    for (let i = 0; i < n; i++) {
        originalProfit += strategy[i] * prices[i];
    }

    let maxProfit = originalProfit;

    // Try modifying each possible segment of length k
    for (let i = 0; i <= n - k; i++) {
        let modifiedProfit = originalProfit;

        // Remove the effect of the original strategy in the segment
        for (let j = 0; j < k; j++) {
            modifiedProfit -= strategy[i + j] * prices[i + j];
        }

        // Add the effect of the modified strategy
        for (let j = 0; j < k / 2; j++) {
            modifiedProfit += 0 * prices[i + j]; // first k/2 elements set to 0 (hold)
        }
        for (let j = k / 2; j < k; j++) {
            modifiedProfit += 1 * prices[i + j]; // last k/2 elements set to 1 (sell)
        }

        maxProfit = Math.max(maxProfit, modifiedProfit);
    }

    return maxProfit;
}