class Solution {
    public int minCost(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            dp[i][1] = nums[i];
        }
        
        for (int j = 2; j <= 3; j++) {
            for (int i = j - 1; i < n; i++) {
                dp[i][j] = Integer.MAX_VALUE;
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k >= j - 1; k--) {
                    minCost = Math.min(minCost, nums[k]);
                    dp[i][j] = Math.min(dp[i][j], (k > 0 ? dp[k - 1][j - 1] : 0) + minCost);
                }
            }
        }
        
        return dp[n - 1][3];
    }
}