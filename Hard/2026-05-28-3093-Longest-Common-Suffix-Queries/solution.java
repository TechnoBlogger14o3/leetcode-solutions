import java.util.*;

public class Solution {
    public int[] longestCommonSuffixQueries(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsContainer.length;
        int[] result = new int[wordsQuery.length];
        
        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            int maxLength = 0;
            int minLength = Integer.MAX_VALUE;
            int bestIndex = -1;

            for (int j = 0; j < n; j++) {
                String word = wordsContainer[j];
                int commonLength = commonSuffixLength(word, query);
                
                if (commonLength > maxLength || 
                    (commonLength == maxLength && word.length() < minLength) || 
                    (commonLength == maxLength && word.length() == minLength && j < bestIndex)) {
                    maxLength = commonLength;
                    minLength = word.length();
                    bestIndex = j;
                }
            }
            result[i] = bestIndex;
        }
        
        return result;
    }

    private int commonSuffixLength(String word, String query) {
        int wordLen = word.length();
        int queryLen = query.length();
        int length = 0;

        while (length < wordLen && length < queryLen && word.charAt(wordLen - 1 - length) == query.charAt(queryLen - 1 - length)) {
            length++;
        }
        
        return length;
    }
}