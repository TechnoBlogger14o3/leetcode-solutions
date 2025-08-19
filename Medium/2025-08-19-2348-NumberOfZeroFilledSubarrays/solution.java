class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long consecutiveZeros = 0;
        
        for (int num : nums) {
            if (num == 0) {
                consecutiveZeros++;
                // Add the count of all subarrays ending at current position
                count += consecutiveZeros;
            } else {
                consecutiveZeros = 0;
            }
        }
        
        return count;
    }
}
