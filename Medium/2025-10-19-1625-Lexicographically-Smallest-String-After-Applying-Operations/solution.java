class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        String smallest = s;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            s = rotate(s, b);
            String modified = addToOddIndices(s, a);
            smallest = min(smallest, modified);
        }
        
        return smallest;
    }
    
    private String rotate(String s, int b) {
        int n = s.length();
        b = b % n;
        return s.substring(n - b) + s.substring(0, n - b);
    }
    
    private String addToOddIndices(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
        }
        return new String(chars);
    }
    
    private String min(String s1, String s2) {
        return s1.compareTo(s2) < 0 ? s1 : s2;
    }
}