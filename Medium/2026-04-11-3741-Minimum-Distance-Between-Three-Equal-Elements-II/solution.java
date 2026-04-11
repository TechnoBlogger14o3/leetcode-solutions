import java.util.*;

public class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (List<Integer> indices : indexMap.values()) {
            if (indices.size() >= 3) {
                for (int i = 0; i < indices.size(); i++) {
                    for (int j = i + 1; j < indices.size(); j++) {
                        for (int k = j + 1; k < indices.size(); k++) {
                            int distance = Math.abs(indices.get(i) - indices.get(j)) +
                                           Math.abs(indices.get(j) - indices.get(k)) +
                                           Math.abs(indices.get(k) - indices.get(i));
                            minDistance = Math.min(minDistance, distance);
                            found = true;
                        }
                    }
                }
            }
        }
        
        return found ? minDistance : -1;
    }
}