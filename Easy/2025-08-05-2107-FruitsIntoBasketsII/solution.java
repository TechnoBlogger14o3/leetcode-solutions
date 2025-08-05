class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] used = new boolean[baskets.length];
        int unplaced = 0;
        
        for (int fruit : fruits) {
            boolean placed = false;
            
            // Find the leftmost available basket with sufficient capacity
            for (int i = 0; i < baskets.length; i++) {
                if (!used[i] && baskets[i] >= fruit) {
                    used[i] = true;  // Mark basket as used
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