class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for (int num : nums) {
            int[] temp = dp.clone();
            for (int i = 0; i < 3; i++) {
                temp[(i + num) % 3] = Math.max(temp[(i + num) % 3], dp[i] + num);
            }
            dp = temp;
        }
        return dp[0];
    }
}