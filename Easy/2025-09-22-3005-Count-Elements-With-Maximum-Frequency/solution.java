import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countMaxFrequency(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(num));
        }

        int totalCount = 0;
        for (int count : frequencyMap.values()) {
            if (count == maxFrequency) {
                totalCount += count;
            }
        }

        return totalCount;
    }
}