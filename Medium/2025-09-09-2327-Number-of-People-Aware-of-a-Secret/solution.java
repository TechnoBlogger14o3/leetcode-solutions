class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1; // On day 1, one person knows the secret

        for (int day = 2; day <= n; day++) {
            for (int j = delay; j < forget; j++) {
                if (day - j >= 1) {
                    dp[day] = (dp[day] + dp[day - j]) % MOD;
                }
            }
        }

        long total = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            total = (total + dp[day]) % MOD;
        }

        return (int) total;
    }
}