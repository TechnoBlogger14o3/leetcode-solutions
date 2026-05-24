var maxJumps = function(arr, d) {
    const n = arr.length;
    const dp = new Array(n).fill(1);
    
    const canJump = (i, j) => {
        const [start, end] = i < j ? [i, j] : [j, i];
        for (let k = start + 1; k < end; k++) {
            if (arr[k] >= arr[i]) return false;
        }
        return true;
    };

    for (let i = 0; i < n; i++) {
        for (let j = 1; j <= d; j++) {
            if (i + j < n && arr[i] > arr[i + j] && canJump(i, i + j)) {
                dp[i + j] = Math.max(dp[i + j], dp[i] + 1);
            }
            if (i - j >= 0 && arr[i] > arr[i - j] && canJump(i, i - j)) {
                dp[i - j] = Math.max(dp[i - j], dp[i] + 1);
            }
        }
    }

    return Math.max(...dp);
};