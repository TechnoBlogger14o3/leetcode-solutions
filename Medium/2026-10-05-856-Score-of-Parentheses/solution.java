class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
            } else {
                depth--;
                if (s.charAt(s.indexOf(c) - 1) == '(') {
                    score += 1 << depth; // 2^depth
                }
            }
        }

        return score;
    }
}