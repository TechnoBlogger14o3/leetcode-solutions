function minChanges(s, k) {
    const n = s.length;
    
    function getMinChanges(sub) {
        const m = sub.length;
        const freq = Array.from({ length: 26 }, () => Array(m).fill(0));
        
        for (let i = 0; i < m; i++) {
            freq[sub.charCodeAt(i) - 'a'.charCodeAt(0)][i % k]++;
        }
        
        let changes = 0;
        for (let i = 0; i < k; i++) {
            let maxFreq = 0;
            for (let j = 0; j < 26; j++) {
                maxFreq = Math.max(maxFreq, freq[j][i]);
            }
            changes += (m / k) - maxFreq;
        }
        
        return changes;
    }
    
    const dp = Array(n + 1).fill(Infinity);
    dp[0] = 0;
    
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= k && j <= i; j++) {
            const sub = s.slice(i - j, i);
            dp[i] = Math.min(dp[i], dp[i - j] + getMinChanges(sub));
        }
    }
    
    return dp[n];
}