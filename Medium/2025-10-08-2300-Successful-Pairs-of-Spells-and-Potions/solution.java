import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];
        
        Arrays.sort(potions);
        
        for (int i = 0; i < n; i++) {
            long requiredPotionStrength = (success + spells[i] - 1) / spells[i]; // ceil(success / spells[i])
            int index = binarySearch(potions, requiredPotionStrength);
            pairs[i] = m - index;
        }
        
        return pairs;
    }
    
    private int binarySearch(int[] potions, long target) {
        int left = 0, right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}