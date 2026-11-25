import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        Map<String, Integer> subarrayCount = new HashMap<>();
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        for (int length = 1; length <= n; length++) {
            subarrayCount.clear();
            for (int start = 0; start <= n - length; start++) {
                StringBuilder sb = new StringBuilder();
                for (int i = start; i < start + length; i++) {
                    sb.append(nums[i]).append(",");
                }
                String subarray = sb.toString();
                subarrayCount.put(subarray, subarrayCount.getOrDefault(subarray, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : subarrayCount.entrySet()) {
                if (entry.getValue() == 1) {
                    minLength = Math.min(minLength, length);
                }
            }

            if (minLength != Integer.MAX_VALUE) {
                break;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}