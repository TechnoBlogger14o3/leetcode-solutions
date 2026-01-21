class Solution {
    public int[] constructArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            ans[i] = -1; // Default value
            
            // Check if we can find a valid ans[i]
            for (int j = 0; j <= num; j++) {
                if ((j | (j + 1)) == num) {
                    ans[i] = j;
                    break;
                }
            }
        }
        
        return ans;
    }
}