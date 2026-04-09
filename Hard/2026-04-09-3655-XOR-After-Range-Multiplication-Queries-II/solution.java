class Solution {
    public int xorQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;
        int n = nums.length;
        long[] bravexuneth = new long[n];
        
        // Apply all queries
        for (int[] query : queries) {
            int l = query[0], r = query[1], k = query[2], v = query[3];
            for (int idx = l; idx <= r; idx += k) {
                nums[idx] = (int)((nums[idx] * (long)v) % MOD);
            }
        }
        
        // Calculate the XOR of all elements
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
}