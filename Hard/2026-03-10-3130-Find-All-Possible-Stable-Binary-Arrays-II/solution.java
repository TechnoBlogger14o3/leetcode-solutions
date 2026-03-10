class Solution {
    private static final int MOD = 1000000007;

    public int countStableArrays(int zero, int one, int limit) {
        long[][] dp = new long[zero + 1][one + 1];
        dp[0][1] = 1; // Base case: one way to have one '1' and no '0's

        for (int z = 0; z <= zero; z++) {
            for (int o = 0; o <= one; o++) {
                if (z > 0) {
                    dp[z][o] = (dp[z][o] + dp[z - 1][o]) % MOD; // Adding a '0'
                }
                if (o > 0) {
                    dp[z][o] = (dp[z][o] + dp[z][o - 1]) % MOD; // Adding a '1'
                }
                if (z > 0 && o > 0 && z + o > limit) {
                    dp[z][o] = (dp[z][o] - dp[Math.max(0, z - limit)][o] + MOD) % MOD; // Removing invalid cases
                }
            }
        }

        return (int) dp[zero][one];
    }
}