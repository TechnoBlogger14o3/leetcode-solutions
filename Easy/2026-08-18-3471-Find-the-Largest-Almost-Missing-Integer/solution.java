import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findLargestAlmostMissingInteger(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i <= n - k; i++) {
            for (int j = i; j < i + k; j++) {
                countMap.put(nums[j], countMap.getOrDefault(nums[j], 0) + 1);
            }
        }

        int largestAlmostMissing = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                largestAlmostMissing = Math.max(largestAlmostMissing, entry.getKey());
            }
        }

        return largestAlmostMissing;
    }
}