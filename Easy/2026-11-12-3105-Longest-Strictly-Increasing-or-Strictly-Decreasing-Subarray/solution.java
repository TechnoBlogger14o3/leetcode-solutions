class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int maxLength = 1;
        int currentLength = 1;

        // Check for strictly increasing and strictly decreasing
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        maxLength = Math.max(maxLength, currentLength);

        currentLength = 1; // Reset for decreasing check
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }
}