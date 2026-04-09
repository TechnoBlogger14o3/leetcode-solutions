var xorQueries = function(nums, queries) {
    const MOD = 1e9 + 7;
    let n = nums.length;
    
    for (let [l, r, k, v] of queries) {
        let idx = l;
        while (idx <= r) {
            nums[idx] = (nums[idx] * v) % MOD;
            idx += k;
        }
    }
    
    return nums.reduce((acc, num) => acc ^ num, 0);
};