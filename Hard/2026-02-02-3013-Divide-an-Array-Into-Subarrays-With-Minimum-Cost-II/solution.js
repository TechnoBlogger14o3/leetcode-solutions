var minCost = function(nums, k, dist) {
    const n = nums.length;
    const dp = Array(n + 1).fill(Infinity);
    dp[0] = 0;

    for (let i = 1; i <= k; i++) {
        const newDp = Array(n + 1).fill(Infinity);
        const minHeap = [];
        let minCost = Infinity;

        for (let j = 0; j < n; j++) {
            if (j >= dist) {
                minHeap.push(dp[j - dist]);
            }
            if (minHeap.length > 0) {
                minCost = Math.min(minCost, minHeap[0]);
            }
            newDp[j + 1] = Math.min(newDp[j + 1], minCost + nums[j]);
            if (j < n - 1) {
                minHeap.push(dp[j]);
            }
        }
        dp.splice(0, n + 1, ...newDp);
    }

    return dp[n];
};