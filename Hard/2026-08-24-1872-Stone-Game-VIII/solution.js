var stoneGameVIII = function(stones) {
    const n = stones.length;
    for (let i = 1; i < n; i++) {
        stones[i] += stones[i - 1];
    }
    
    let maxDiff = stones[n - 1];
    let result = maxDiff;
    
    for (let i = n - 2; i > 0; i--) {
        maxDiff = Math.max(maxDiff, stones[i]);
        result = Math.max(result, stones[i] - maxDiff);
    }
    
    return result;
};