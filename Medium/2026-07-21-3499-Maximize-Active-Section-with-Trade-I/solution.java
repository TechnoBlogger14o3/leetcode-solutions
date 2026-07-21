class Solution {
    public int maximizeActiveSections(String s) {
        String t = "1" + s + "1";
        int n = t.length();
        int maxActiveSections = 0;
        int currentActiveSections = 0;
        
        for (int i = 0; i < n; i++) {
            if (t.charAt(i) == '1') {
                if (i == 0 || t.charAt(i - 1) == '0') {
                    currentActiveSections++;
                }
            }
        }
        
        maxActiveSections = currentActiveSections;
        
        for (int i = 1; i < n - 1; i++) {
            if (t.charAt(i) == '0' && t.charAt(i - 1) == '1' && t.charAt(i + 1) == '1') {
                int left = i - 1;
                int right = i + 1;
                
                while (left >= 0 && t.charAt(left) == '1') {
                    left--;
                }
                while (right < n && t.charAt(right) == '1') {
                    right++;
                }
                
                int newActiveSections = currentActiveSections - 1 + (right - left - 1);
                maxActiveSections = Math.max(maxActiveSections, newActiveSections);
            }
        }
        
        return maxActiveSections;
    }
}