class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Find the shortest string
        String shortest = strs[0];
        for (String s : strs) {
            if (s.length() < shortest.length()) {
                shortest = s;
            }
        }
        
        // Check each character of the shortest string
        for (int i = 0; i < shortest.length(); i++) {
            char c = shortest.charAt(i);
            // Check if all strings have the same character at position i
            for (String s : strs) {
                if (s.charAt(i) != c) {
                    return shortest.substring(0, i);
                }
            }
        }
        
        return shortest;
    }
}

