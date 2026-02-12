class Solution {
    public int longestBalancedSubstring(String s) {
        int maxLength = 0;
        int n = s.length();
        
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                String substring = s.substring(start, start + len);
                if (isBalanced(substring)) {
                    maxLength = Math.max(maxLength, len);
                }
            }
        }
        
        return maxLength;
    }
    
    private boolean isBalanced(String substring) {
        int[] count = new int[26];
        for (char c : substring.toCharArray()) {
            count[c - 'a']++;
        }
        
        int frequency = 0;
        boolean first = true;
        
        for (int c : count) {
            if (c > 0) {
                if (first) {
                    frequency = c;
                    first = false;
                } else if (c != frequency) {
                    return false;
                }
            }
        }
        
        return true;
    }
}