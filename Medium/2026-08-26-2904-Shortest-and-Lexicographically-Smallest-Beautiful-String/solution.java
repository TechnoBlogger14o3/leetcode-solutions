class Solution {
    public String smallestBeautifulString(String s, int k) {
        int n = s.length();
        String result = "";
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String substring = s.substring(i, j);
                if (countOnes(substring) == k) {
                    if (result.isEmpty() || substring.length() < result.length() || 
                        (substring.length() == result.length() && substring.compareTo(result) < 0)) {
                        result = substring;
                    }
                }
            }
        }
        
        return result;
    }
    
    private int countOnes(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}