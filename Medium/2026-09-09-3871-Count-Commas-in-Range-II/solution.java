class Solution {
    public long countCommas(int n) {
        long count = 0;
        for (long i = 1; i <= n; i++) {
            if (i >= 1000) {
                count += (String.valueOf(i).length() - 1) / 3;
            }
        }
        return count;
    }
}