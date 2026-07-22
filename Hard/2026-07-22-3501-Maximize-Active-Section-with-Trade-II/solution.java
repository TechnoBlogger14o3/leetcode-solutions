import java.util.*;

public class Solution {
    public int[] maximizeActiveSections(String s, int[][] queries) {
        int n = s.length();
        int[] result = new int[queries.length];
        
        // Precompute the number of active sections in the original string
        int originalActiveSections = countActiveSections(s);
        
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            String augmented = "1" + s.substring(l, r + 1) + "1";
            int maxActiveSections = originalActiveSections;
            
            // Count the number of active sections in the augmented string
            int activeSectionsInAugmented = countActiveSections(augmented);
            maxActiveSections = Math.max(maxActiveSections, activeSectionsInAugmented);
            
            // Check for possible trades
            maxActiveSections = Math.max(maxActiveSections, calculateMaxWithTrade(s, l, r, originalActiveSections));
            result[i] = maxActiveSections;
        }
        
        return result;
    }
    
    private int countActiveSections(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && (i == 0 || s.charAt(i - 1) == '0')) {
                count++;
            }
        }
        return count;
    }
    
    private int calculateMaxWithTrade(String s, int l, int r, int originalActiveSections) {
        int left = l > 0 && s.charAt(l - 1) == '1' ? 1 : 0;
        int right = r < s.length() - 1 && s.charAt(r + 1) == '1' ? 1 : 0;
        
        // If there are no active sections to trade, return original count
        if (left == 0 && right == 0) {
            return originalActiveSections;
        }
        
        // If we can trade, we can potentially increase the active sections
        return originalActiveSections + 1 - left - right;
    }
}