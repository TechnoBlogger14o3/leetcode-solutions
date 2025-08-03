import java.util.*;

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        // Sort fruits by position
        Arrays.sort(fruits, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = fruits.length;
        int maxFruits = 0;
        int left = 0;
        int currentSum = 0;
        
        // Sliding window approach
        for (int right = 0; right < n; right++) {
            currentSum += fruits[right][1];
            
            // Shrink window from left while it's invalid
            while (left <= right) {
                int leftPos = fruits[left][0];
                int rightPos = fruits[right][0];
                
                // Calculate minimum steps needed for current window
                int steps = rightPos - leftPos + Math.min(Math.abs(startPos - leftPos), Math.abs(startPos - rightPos));
                
                if (steps <= k) {
                    break; // Window is valid, keep it
                }
                
                // Remove leftmost fruit and shrink window
                currentSum -= fruits[left][1];
                left++;
            }
            
            // Update max fruits if window is valid
            if (left <= right) {
                maxFruits = Math.max(maxFruits, currentSum);
            }
        }
        
        return maxFruits;
    }
} 