var countOrders = function(complexity) {
    const MOD = 1e9 + 7;
    const n = complexity.length;
    complexity.sort((a, b) => a - b);
    
    let dp = new Array(n + 1).fill(0);
    dp[0] = 1;
    
    for (let i = 1; i <= n; i++) {
        let count = 0;
        for (let j = 0; j < i; j++) {
            if (complexity[j] < complexity[i - 1]) {
                count++;
            }
        }
        dp[i] = (dp[i - 1] * count) % MOD;
    }
    
    return dp[n];
};

// Example test cases
console.log(countOrders([1, 2, 3])); // Output: 2
console.log(countOrders([3, 3, 3, 4, 4, 4])); // Output: 0