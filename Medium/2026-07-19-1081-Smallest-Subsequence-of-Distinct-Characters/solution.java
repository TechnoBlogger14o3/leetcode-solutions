import java.util.Stack;

class Solution {
    public String smallestSubsequence(String s) {
        int[] lastOccurrence = new int[26];
        boolean[] inResult = new boolean[26];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (inResult[currentChar - 'a']) {
                continue;
            }
            while (result.length() > 0 && result.charAt(result.length() - 1) > currentChar 
                   && lastOccurrence[result.charAt(result.length() - 1) - 'a'] > i) {
                inResult[result.charAt(result.length() - 1) - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }
            result.append(currentChar);
            inResult[currentChar - 'a'] = true;
        }

        return result.toString();
    }
}