import java.util.HashSet;

public class Solution {
    public int countPalindromicSubseq(String s) {
        HashSet<String> uniquePalindromes = new HashSet<>();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    for (int k = j + 1; k < n; k++) {
                        if (s.charAt(i) == s.charAt(k)) {
                            uniquePalindromes.add("" + s.charAt(i) + s.charAt(j) + s.charAt(k));
                        }
                    }
                }
            }
        }
        
        return uniquePalindromes.size();
    }
}