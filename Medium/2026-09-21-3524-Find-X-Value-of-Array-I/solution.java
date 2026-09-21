class Solution {
    public int[] findXValue(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        long[] prefixProducts = new long[n + 1];
        long[] suffixProducts = new long[n + 1];
        
        prefixProducts[0] = 1;
        for (int i = 0; i < n; i++) {
            prefixProducts[i + 1] = (prefixProducts[i] * nums[i]) % k;
        }
        
        suffixProducts[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            suffixProducts[i] = (suffixProducts[i + 1] * nums[i]) % k;
        }
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i + j < n) {
                    int productMod = (int) ((prefixProducts[i] * suffixProducts[j]) % k);
                    result[productMod]++;
                }
            }
        }
        
        return result;
    }
}