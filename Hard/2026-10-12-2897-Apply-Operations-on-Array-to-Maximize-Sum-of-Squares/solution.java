import java.util.Arrays;

class Solution {
    public int maximumSumOfSquares(int[] nums, int k) {
        int MOD = 1000000007;
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;
        
        for (int i = n - k; i < n; i++) {
            sum = (sum + (long) nums[i] * nums[i]) % MOD;
        }
        
        return (int) sum;
    }
}