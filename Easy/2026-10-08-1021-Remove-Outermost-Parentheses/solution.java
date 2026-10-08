class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance++ > 0) {
                    result.append(c);
                }
            } else {
                if (--balance > 0) {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
}