import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        
        // Precompute all palindromes
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    isPalindrome[i][j] = true;
                } else if (len == 2) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
                }
            }
        }
        
        List<Integer> palindromes = new ArrayList<>();
        
        // Collect all palindromic substrings of length at least k
        for (int i = 0; i <= n - k; i++) {
            for (int j = i + k - 1; j < n; j++) {
                if (isPalindrome[i][j]) {
                    palindromes.add(i);
                }
            }
        }
        
        return findMaxNonOverlappingPalindromes(palindromes);
    }
    
    private int findMaxNonOverlappingPalindromes(List<Integer> palindromes) {
        int count = 0;
        int lastEnd = -1;
        
        for (int start : palindromes) {
            if (start > lastEnd) {
                count++;
                lastEnd = start + (start + 1); // Update lastEnd to the end of the palindrome
            }
        }
        
        return count;
    }
}