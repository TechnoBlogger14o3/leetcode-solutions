import java.util.*;

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        // Sort fruits by position
        Arrays.sort(fruits, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = fruits.length;
        int maxFruits = 0;
        
        // Try all possible ranges
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                int leftPos = fruits[left][0];
                int rightPos = fruits[right][0];
                
                // Calculate minimum steps needed
                int steps = rightPos - leftPos + Math.min(Math.abs(startPos - leftPos), Math.abs(startPos - rightPos));
                
                if (steps <= k) {
                    // Calculate total fruits in this range
                    int totalFruits = 0;
                    for (int i = left; i <= right; i++) {
                        totalFruits += fruits[i][1];
                    }
                    maxFruits = Math.max(maxFruits, totalFruits);
                }
            }
        }
        
        return maxFruits;
    }
} 