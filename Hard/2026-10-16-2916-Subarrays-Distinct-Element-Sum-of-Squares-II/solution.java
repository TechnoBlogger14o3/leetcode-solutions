import java.util.HashMap;

class Solution {
    public int distinctCountSumOfSquares(int[] nums) {
        int n = nums.length;
        long result = 0;
        long mod = 1000000007;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);

            while (countMap.get(nums[right]) > 1) {
                countMap.put(nums[left], countMap.get(nums[left]) - 1);
                if (countMap.get(nums[left]) == 0) {
                    countMap.remove(nums[left]);
                }
                left++;
            }

            int distinctCount = countMap.size();
            result = (result + (long) distinctCount * distinctCount) % mod;
        }

        return (int) result;
    }
}