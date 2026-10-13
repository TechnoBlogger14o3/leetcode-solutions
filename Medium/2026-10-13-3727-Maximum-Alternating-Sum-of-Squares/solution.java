import java.util.Arrays;

class Solution {
    public int maximumAlternatingSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxScore = 0;
        
        for (int i = n - 1; i >= 0; i -= 2) {
            maxScore += nums[i] * nums[i];
        }
        
        for (int i = n - 2; i >= 0; i -= 2) {
            maxScore -= nums[i] * nums[i];
        }
        
        return maxScore;
    }
}