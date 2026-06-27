import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaximumSubsetSize(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int maxSize = 0;
        for (int num : countMap.keySet()) {
            int size = countMap.get(num);
            int power = num * 2;
            while (countMap.containsKey(power)) {
                size += countMap.get(power);
                power *= 2;
            }
            maxSize = Math.max(maxSize, size);
        }

        return maxSize;
    }
}