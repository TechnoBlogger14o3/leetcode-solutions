class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1; // Base case: empty subsequence

        // To keep track of the last occurrence of each character
        int[] last = new int[26];
        
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            dp[i] = (2 * dp[i - 1]) % MOD; // Each subsequence can either include or exclude the current character
            
            // If the character has appeared before, subtract the subsequences that were counted twice
            if (last[c - 'a'] > 0) {
                dp[i] = (dp[i] - dp[last[c - 'a'] - 1] + MOD) % MOD;
            }
            
            // Update the last occurrence of the character
            last[c - 'a'] = i;
        }
        
        // Subtract 1 to exclude the empty subsequence
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}