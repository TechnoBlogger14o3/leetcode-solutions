class Solution {
    public long minTimeToBrewPotions(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[][] dp = new long[n][m];
        
        // Calculate the time for the first potion
        dp[0][0] = skill[0] * mana[0];
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + skill[0] * mana[j];
        }
        
        // Calculate the time for the rest of the potions
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + skill[i] * mana[0];
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + skill[i] * mana[j];
            }
        }
        
        return dp[n - 1][m - 1];
    }
}