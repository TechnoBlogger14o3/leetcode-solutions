var maxSideLength = function(mat, threshold) {
    const m = mat.length, n = mat[0].length;
    const prefixSum = Array.from({ length: m + 1 }, () => Array(n + 1).fill(0));
    
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            prefixSum[i][j] = mat[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
        }
    }
    
    let left = 0, right = Math.min(m, n);
    
    while (left < right) {
        const mid = Math.floor((left + right + 1) / 2);
        let found = false;
        
        for (let i = mid; i <= m; i++) {
            for (let j = mid; j <= n; j++) {
                const sum = prefixSum[i][j] - prefixSum[i - mid][j] - prefixSum[i][j - mid] + prefixSum[i - mid][j - mid];
                if (sum <= threshold) {
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        
        if (found) {
            left = mid;
        } else {
            right = mid - 1;
        }
    }
    
    return left;
};