class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfWays(String corridor) {
        int seatCount = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') seatCount++;
        }
        
        if (seatCount % 2 != 0) return 0;
        if (seatCount == 0) return 1;

        int pairs = seatCount / 2;
        long[] dp = new long[pairs + 1];
        dp[0] = 1;

        int plantCount = 0;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                if (plantCount > 0) {
                    for (int j = pairs; j > 0; j--) {
                        dp[j] = (dp[j] + dp[j - 1] * plantCount) % MOD;
                    }
                }
                plantCount = 0;
            } else {
                plantCount++;
            }
        }

        return (int) dp[pairs];
    }
}