class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;
        for (int[] query : queries) {
            int l = query[0], r = query[1], k = query[2], v = query[3];
            for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (int)((long)nums[idx] * v % MOD);
            }
        }
        
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
}