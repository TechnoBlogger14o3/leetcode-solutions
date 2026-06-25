class Solution {
    public int countSubarrays(int[] nums, int target) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                int majorityCount = 0;
                for (int j = i; j < n; j++) {
                    if (nums[j] == target) {
                        majorityCount++;
                    }
                    if (j - i + 1 > 2 * majorityCount) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}