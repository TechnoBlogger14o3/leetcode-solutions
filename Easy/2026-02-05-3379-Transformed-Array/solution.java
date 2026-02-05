class Solution {
    public int[] circularArrayLoop(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[i] = (i + nums[i]) % n;
            } else if (nums[i] < 0) {
                result[i] = (i + nums[i] + n) % n;
            } else {
                result[i] = 0;
            }
        }
        
        return result;
    }
}