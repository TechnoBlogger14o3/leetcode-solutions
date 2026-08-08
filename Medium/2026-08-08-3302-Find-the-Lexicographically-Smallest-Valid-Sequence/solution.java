import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] findTheLexicographicallySmallestValidSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0, j = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                result.add(i);
                j++;
            } else if (j < m - 1 && word1.charAt(i) == word2.charAt(j + 1)) {
                result.add(i);
                j++;
                if (j < m) {
                    result.add(i);
                }
            }
        }
        
        if (result.size() != m) {
            return new int[0];
        }
        
        for (int i = 0; i < result.size(); i++) {
            if (i > 0 && result.get(i) <= result.get(i - 1)) {
                return new int[0];
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}