var minOperations = function(nums, x, k) {
    const n = nums.length;
    const prefixSum = new Array(n + 1).fill(0);
    
    for (let i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
    
    const minOps = new Array(n).fill(Infinity);
    
    for (let i = 0; i <= n - x; i++) {
        const target = Math.round((prefixSum[i + x] - prefixSum[i]) / x);
        let ops = 0;
        
        for (let j = i; j < i + x; j++) {
            ops += Math.abs(nums[j] - target);
        }
        
        minOps[i] = ops;
    }
    
    let result = Infinity;
    
    for (let i = 0; i <= n - k * x; i++) {
        let totalOps = 0;
        let count = 0;
        
        for (let j = i; j <= n - x; j++) {
            if (count < k) {
                totalOps += minOps[j];
                count++;
                j += x - 1;
            }
        }
        
        if (count === k) {
            result = Math.min(result, totalOps);
        }
    }
    
    return result === Infinity ? -1 : result;
};