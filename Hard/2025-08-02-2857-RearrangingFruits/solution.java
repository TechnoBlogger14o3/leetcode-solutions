import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        // Check if sums are equal
        long sum1 = 0, sum2 = 0;
        for (int fruit : basket1) sum1 += fruit;
        for (int fruit : basket2) sum2 += fruit;
        
        if (sum1 != sum2) return -1;
        
        // Count frequencies
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();
        
        for (int fruit : basket1) freq1.put(fruit, freq1.getOrDefault(fruit, 0) + 1);
        for (int fruit : basket2) freq2.put(fruit, freq2.getOrDefault(fruit, 0) + 1);
        
        // Check if each fruit type has even total count
        Set<Integer> allFruits = new HashSet<>();
        allFruits.addAll(freq1.keySet());
        allFruits.addAll(freq2.keySet());
        
        for (int fruit : allFruits) {
            int total = freq1.getOrDefault(fruit, 0) + freq2.getOrDefault(fruit, 0);
            if (total % 2 != 0) return -1;
        }
        
        // Calculate excess/deficit
        List<Integer> excess = new ArrayList<>();
        List<Integer> deficit = new ArrayList<>();
        
        for (int fruit : allFruits) {
            int count1 = freq1.getOrDefault(fruit, 0);
            int count2 = freq2.getOrDefault(fruit, 0);
            int target = (count1 + count2) / 2;
            
            if (count1 > target) {
                for (int i = 0; i < count1 - target; i++) {
                    excess.add(fruit);
                }
            } else if (count2 > target) {
                for (int i = 0; i < count2 - target; i++) {
                    deficit.add(fruit);
                }
            }
        }
        
        // Sort for optimal matching
        Collections.sort(excess);
        Collections.sort(deficit);
        
        long cost = 0;
        for (int i = 0; i < excess.size(); i++) {
            cost += Math.min(excess.get(i), deficit.get(i));
        }
        
        return cost;
    }
} 