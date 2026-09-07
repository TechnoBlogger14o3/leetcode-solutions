var distinctSubseqII = function(s) {
    const MOD = 1e9 + 7;
    const n = s.length;
    const dp = new Array(n + 1).fill(0);
    const last = new Array(26).fill(-1);
    
    dp[0] = 1; // Base case: empty subsequence
    
    for (let i = 1; i <= n; i++) {
        dp[i] = (2 * dp[i - 1]) % MOD; // Each subsequence can either include or exclude s[i - 1]
        
        const charIndex = s.charCodeAt(i - 1) - 'a'.charCodeAt(0);
        if (last[charIndex] !== -1) {
            dp[i] = (dp[i] - dp[last[charIndex]] + MOD) % MOD; // Remove duplicates
        }
        
        last[charIndex] = i - 1; // Update the last occurrence of the character
    }
    
    return (dp[n] - 1 + MOD) % MOD; // Subtract 1 to exclude the empty subsequence
};