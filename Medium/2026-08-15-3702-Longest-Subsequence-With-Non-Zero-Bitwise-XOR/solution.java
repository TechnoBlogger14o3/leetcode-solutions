class Solution {
    public int longestSubsequence(int[] nums) {
        int count = 0;
        int totalXor = 0;

        for (int num : nums) {
            totalXor ^= num;
        }

        if (totalXor != 0) {
            return nums.length;
        }

        for (int num : nums) {
            if (num != 0) {
                count++;
            }
        }

        return count > 0 ? count : 0;
    }
}