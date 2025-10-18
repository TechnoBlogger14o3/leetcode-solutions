import java.util.*;

class Solution {
    public int maximumDistinctElements(int[] nums, int k) {
        Set<Integer> distinctElements = new HashSet<>();
        for (int num : nums) {
            distinctElements.add(num);
        }
        
        List<Integer> sortedDistinct = new ArrayList<>(distinctElements);
        Collections.sort(sortedDistinct);
        
        int count = sortedDistinct.size();
        for (int i = 0; i < sortedDistinct.size(); i++) {
            int current = sortedDistinct.get(i);
            if (k > 0) {
                int newElement = current - k;
                if (newElement >= 1 && !distinctElements.contains(newElement)) {
                    distinctElements.add(newElement);
                    k = 0; // Use k for this operation
                }
            }
            if (k > 0) {
                int newElement = current + k;
                if (!distinctElements.contains(newElement)) {
                    distinctElements.add(newElement);
                    k = 0; // Use k for this operation
                }
            }
        }
        
        return distinctElements.size();
    }
}