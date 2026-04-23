var distance = function(nums) {
    const n = nums.length;
    const map = new Map();
    const result = new Array(n).fill(0);
    
    for (let i = 0; i < n; i++) {
        if (!map.has(nums[i])) {
            map.set(nums[i], []);
        }
        map.get(nums[i]).push(i);
    }
    
    for (const indices of map.values()) {
        const m = indices.length;
        if (m < 2) continue;
        
        const prefixSum = new Array(m + 1).fill(0);
        for (let i = 1; i <= m; i++) {
            prefixSum[i] = prefixSum[i - 1] + indices[i - 1];
        }
        
        for (let i = 0; i < m; i++) {
            const leftCount = i;
            const rightCount = m - 1 - i;
            const leftSum = prefixSum[i];
            const rightSum = prefixSum[m] - prefixSum[i + 1];
            result[indices[i]] = leftCount * indices[i] - leftSum + rightSum - rightCount * indices[i];
        }
    }
    
    return result;
};