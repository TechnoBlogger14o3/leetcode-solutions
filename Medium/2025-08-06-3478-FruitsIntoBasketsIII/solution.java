import java.util.*;

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int minUnplaced = Integer.MAX_VALUE;
        
        // Try placing all fruits without skipping
        minUnplaced = Math.min(minUnplaced, placeFruitsOptimized(fruits, baskets, -1));
        
        // Try skipping each fruit type
        for (int skipIndex = 0; skipIndex < fruits.length; skipIndex++) {
            minUnplaced = Math.min(minUnplaced, placeFruitsOptimized(fruits, baskets, skipIndex));
        }
        
        return minUnplaced;
    }
    
    private int placeFruitsOptimized(int[] fruits, int[] baskets, int skipIndex) {
        // Use TreeSet to maintain available baskets efficiently
        TreeSet<Integer> availableBaskets = new TreeSet<>();
        for (int basket : baskets) {
            availableBaskets.add(basket);
        }
        
        int unplaced = 0;
        
        for (int i = 0; i < fruits.length; i++) {
            if (i == skipIndex) {
                unplaced++; // Count skipped fruit as unplaced
                continue;
            }
            
            // Find the smallest available basket that can hold this fruit
            Integer basket = availableBaskets.ceiling(fruits[i]);
            
            if (basket == null) {
                unplaced++;
            } else {
                availableBaskets.remove(basket);
            }
        }
        
        return unplaced;
    }
} 