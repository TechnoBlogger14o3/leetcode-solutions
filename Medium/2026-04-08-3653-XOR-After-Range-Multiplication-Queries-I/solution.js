var xorQueries = function(nums, queries) {
    const MOD = 1e9 + 7;
    const n = nums.length;

    for (const [l, r, k, v] of queries) {
        for (let idx = l; idx <= r; idx += k) {
            nums[idx] = (nums[idx] * v) % MOD;
        }
    }

    return nums.reduce((acc, num) => acc ^ num, 0);
};