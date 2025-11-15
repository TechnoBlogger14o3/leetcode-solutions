class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int ones = 0, zeros = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') {
                    ones++;
                } else {
                    zeros++;
                }
                if (ones >= zeros * zeros) {
                    count++;
                }
            }
        }

        return count;
    }
}