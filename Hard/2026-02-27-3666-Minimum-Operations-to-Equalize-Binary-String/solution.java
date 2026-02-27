class Solution {
    public int minimumOperations(String s, int k) {
        int countZeroes = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                countZeroes++;
            }
        }
        
        if (countZeroes == 0) {
            return 0;
        }
        
        if (countZeroes < k) {
            return -1;
        }
        
        if (k == 1) {
            return countZeroes;
        }
        
        return (countZeroes + k - 1) / k;
    }
}