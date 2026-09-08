class Solution {
    public int countCommas(int n) {
        int totalCommas = 0;
        for (int i = 1; i <= n; i++) {
            totalCommas += countCommasInNumber(i);
        }
        return totalCommas;
    }
    
    private int countCommasInNumber(int num) {
        if (num < 1000) {
            return 0;
        }
        return (String.valueOf(num).length() - 1) / 3;
    }
}