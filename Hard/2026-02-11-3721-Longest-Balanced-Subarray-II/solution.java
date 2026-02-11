import java.util.HashMap;

public class Solution {
    public int longestBalancedSubarray(int[] nums) {
        HashMap<Integer, Integer> evenCount = new HashMap<>();
        HashMap<Integer, Integer> oddCount = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 0) {
                evenCount.put(nums[right], evenCount.getOrDefault(nums[right], 0) + 1);
            } else {
                oddCount.put(nums[right], oddCount.getOrDefault(nums[right], 0) + 1);
            }

            while (evenCount.size() > oddCount.size()) {
                if (nums[left] % 2 == 0) {
                    evenCount.put(nums[left], evenCount.get(nums[left]) - 1);
                    if (evenCount.get(nums[left]) == 0) {
                        evenCount.remove(nums[left]);
                    }
                } else {
                    oddCount.put(nums[left], oddCount.get(nums[left]) - 1);
                    if (oddCount.get(nums[left]) == 0) {
                        oddCount.remove(nums[left]);
                    }
                }
                left++;
            }

            if (evenCount.size() == oddCount.size()) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}