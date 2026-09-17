var minSumOfLengths = function(arr, target) {
    const n = arr.length;
    const dp = new Array(n).fill(Infinity);
    let sum = 0;
    let left = 0;
    
    for (let right = 0; right < n; right++) {
        sum += arr[right];
        
        while (sum > target) {
            sum -= arr[left++];
        }
        
        if (sum === target) {
            dp[right] = right - left + 1;
        }
    }
    
    for (let i = 1; i < n; i++) {
        dp[i] = Math.min(dp[i], dp[i - 1]);
    }
    
    sum = 0;
    left = 0;
    let result = Infinity;
    
    for (let right = 0; right < n; right++) {
        sum += arr[right];
        
        while (sum > target) {
            sum -= arr[left++];
        }
        
        if (sum === target) {
            if (left > 0) {
                result = Math.min(result, dp[left - 1] + right - left + 1);
            }
        }
    }
    
    return result === Infinity ? -1 : result;
};