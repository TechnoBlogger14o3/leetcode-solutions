class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            int maxScore = Integer.MIN_VALUE;
            int sum = 0;
            for (int j = 0; j < 3 && i + j < n; j++) {
                sum += stoneValue[i + j];
                maxScore = Math.max(maxScore, sum - dp[i + j + 1]);
            }
            dp[i] = maxScore;
        }
        
        if (dp[0] > 0) return "Alice";
        else if (dp[0] < 0) return "Bob";
        else return "Tie";
    }
}