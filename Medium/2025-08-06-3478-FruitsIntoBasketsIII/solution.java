class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int minUnplaced = Integer.MAX_VALUE;
        
        // Try placing all fruits without skipping
        minUnplaced = Math.min(minUnplaced, placeFruits(fruits, baskets, -1));
        
        // Try skipping each fruit type
        for (int skipIndex = 0; skipIndex < fruits.length; skipIndex++) {
            minUnplaced = Math.min(minUnplaced, placeFruits(fruits, baskets, skipIndex));
        }
        
        return minUnplaced;
    }
    
    private int placeFruits(int[] fruits, int[] baskets, int skipIndex) {
        boolean[] used = new boolean[baskets.length];
        int unplaced = 0;
        
        for (int i = 0; i < fruits.length; i++) {
            if (i == skipIndex) {
                unplaced++; // Count skipped fruit as unplaced
                continue;
            }
            
            boolean placed = false;
            
            // Find the leftmost available basket with sufficient capacity
            for (int j = 0; j < baskets.length; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true;  // Mark basket as used
                    placed = true;
                    break;
                }
            }
            
            if (!placed) {
                unplaced++;
            }
        }
        
        return unplaced;
    }
} 