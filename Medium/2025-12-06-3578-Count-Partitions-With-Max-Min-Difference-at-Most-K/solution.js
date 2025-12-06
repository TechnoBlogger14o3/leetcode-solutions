var countPartitions = function(nums, k) {
    const MOD = 1e9 + 7;
    const n = nums.length;
    let dp = new Array(n + 1).fill(0);
    dp[0] = 1; // Base case: one way to partition an empty array

    for (let i = 1; i <= n; i++) {
        let minVal = nums[i - 1];
        let maxVal = nums[i - 1];
        for (let j = i; j > 0; j--) {
            minVal = Math.min(minVal, nums[j - 1]);
            maxVal = Math.max(maxVal, nums[j - 1]);
            if (maxVal - minVal > k) break; // Stop if the condition is violated
            dp[i] = (dp[i] + dp[j - 1]) % MOD; // Update the dp array
        }
    }

    return dp[n];
};