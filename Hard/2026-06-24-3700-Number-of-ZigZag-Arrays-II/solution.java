class Solution {
    private static final int MOD = 1000000007;

    public int zigzagArrays(int n, int l, int r) {
        if (n == 1) return r - l + 1;
        
        long count = r - l + 1;
        long prevCount = count;
        long currCount = (count * (count - 1)) % MOD;

        for (int i = 3; i <= n; i++) {
            long temp = currCount;
            currCount = (prevCount * (count - 1) % MOD + currCount * (count - 2) % MOD) % MOD;
            prevCount = temp;
        }

        return (int) currCount;
    }
}