var minCost = function(nums) {
    const n = nums.length;
    let minCost = Infinity;

    for (let i = 0; i < n - 2; i++) {
        for (let j = i + 1; j < n - 1; j++) {
            const cost = nums[i] + nums[j] + nums[Math.min(j + 1, n - 1)];
            minCost = Math.min(minCost, cost);
        }
    }

    return minCost;
};