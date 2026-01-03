class Solution {
    public int numOfWays(int n) {
        final int MOD = 1000000007;
        long same = 6; // Ways to paint two adjacent cells the same color
        long diff = 6; // Ways to paint two adjacent cells different colors
        long total = (same + diff) % MOD;

        for (int i = 2; i <= n; i++) {
            long newSame = (diff * 2) % MOD;
            long newDiff = (total * 3) % MOD;
            same = newSame;
            diff = newDiff;
            total = (same + diff) % MOD;
        }

        return (int) total;
    }
}