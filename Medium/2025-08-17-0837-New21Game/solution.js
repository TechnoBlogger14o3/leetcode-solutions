/**
 * @param {number} N
 * @param {number} K
 * @param {number} maxPts
 * @return {number}
 */
var new21Game = function(N, K, maxPts) {
    if (K === 0 || N >= K - 1 + maxPts) return 1.0;
    let dp = new Array(N + 1).fill(0);
    dp[0] = 1.0;
    let probability = 0.0, windowSum = 1.0;
    for (let i = 1; i <= N; i++) {
        dp[i] = windowSum / maxPts;
        if (i < K) windowSum += dp[i];
        else probability += dp[i];
        if (i >= maxPts) windowSum -= dp[i - maxPts];
    }
    return probability;
};
