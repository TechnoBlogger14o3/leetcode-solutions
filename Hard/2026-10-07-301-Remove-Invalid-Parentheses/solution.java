import java.util.*;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> result = new HashSet<>();
        int[] count = countInvalidParentheses(s);
        backtrack(s, 0, count[0], count[1], 0, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private int[] countInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        return new int[]{left, right};
    }

    private void backtrack(String s, int index, int leftRem, int rightRem, int balance, StringBuilder path, Set<String> result) {
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0 && balance == 0) {
                result.add(path.toString());
            }
            return;
        }

        char c = s.charAt(index);
        if (c == '(') {
            if (leftRem > 0) backtrack(s, index + 1, leftRem - 1, rightRem, balance, path, result); // Exclude
            path.append(c);
            backtrack(s, index + 1, leftRem, rightRem, balance + 1, path, result); // Include
            path.deleteCharAt(path.length() - 1);
        } else if (c == ')') {
            if (rightRem > 0) backtrack(s, index + 1, leftRem, rightRem - 1, balance, path, result); // Exclude
            if (balance > 0) {
                path.append(c);
                backtrack(s, index + 1, leftRem, rightRem, balance - 1, path, result); // Include
                path.deleteCharAt(path.length() - 1);
            }
        } else {
            path.append(c);
            backtrack(s, index + 1, leftRem, rightRem, balance, path, result); // Include letter
            path.deleteCharAt(path.length() - 1);
        }
    }
}