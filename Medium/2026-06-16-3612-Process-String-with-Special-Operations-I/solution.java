class Solution {
    public String processString(String s) {
        StringBuilder result = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(c);
            } else if (c == '*') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (c == '#') {
                result.append(result);
            } else if (c == '%') {
                result.reverse();
            }
        }
        
        return result.toString();
    }
}