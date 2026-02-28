class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        final int MOD = 1_000_000_007;
        for (int i = 1; i <= n; i++) {
            result = ((result << Integer.toBinaryString(i).length()) % MOD + i) % MOD;
        }
        return (int) result;
    }
}