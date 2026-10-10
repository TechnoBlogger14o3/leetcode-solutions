var minSumSquareDiff = function(nums1, nums2, k1, k2) {
    const n = nums1.length;
    const diffs = new Array(n);
    
    for (let i = 0; i < n; i++) {
        diffs[i] = Math.abs(nums1[i] - nums2[i]);
    }
    
    diffs.sort((a, b) => b - a);
    
    let totalDiff = diffs.reduce((sum, diff) => sum + diff * diff, 0);
    
    let totalK = k1 + k2;
    
    for (let i = 0; i < n && totalK > 0; i++) {
        if (diffs[i] === 0) break;
        
        const reduceBy = Math.min(diffs[i], totalK);
        diffs[i] -= reduceBy;
        totalK -= reduceBy;
    }
    
    return diffs.reduce((sum, diff) => sum + diff * diff, 0);
};