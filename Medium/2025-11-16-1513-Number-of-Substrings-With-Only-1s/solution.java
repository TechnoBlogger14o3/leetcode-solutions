class Solution {
    public int numSub(String s) {
        long count = 0;
        long current = 0;
        final int MOD = 1000000007;
        
        for (char c : s.toCharArray()) {
            if (c == '1') {
                current++;
                count = (count + current) % MOD;
            } else {
                current = 0;
            }
        }
        
        return (int) count;
    }
}