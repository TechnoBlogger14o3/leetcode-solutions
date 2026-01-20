class Solution {
    public int[] constructDistancedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int candidate = -1;
            for (int j = 0; j <= num; j++) {
                if ((j | (j + 1)) == num) {
                    candidate = j;
                    break;
                }
            }
            ans[i] = candidate;
        }
        
        return ans;
    }
}