class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(current.toString());
                current = new StringBuilder();
            } else if (c == ')') {
                StringBuilder temp = new StringBuilder(current);
                current = new StringBuilder(stack.pop());
                current.append(temp.reverse());
            } else {
                current.append(c);
            }
        }
        
        return current.toString();
    }
}