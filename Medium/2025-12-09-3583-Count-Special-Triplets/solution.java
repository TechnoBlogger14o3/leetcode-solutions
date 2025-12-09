class Solution {
    public int countTriplets(int[] nums) {
        int mod = 1000000007;
        int n = nums.length;
        long count = 0;
        
        // Count occurrences of each number
        int[] freq = new int[100001];
        for (int num : nums) {
            freq[num]++;
        }
        
        // Iterate through each possible value of nums[j]
        for (int j = 0; j < n; j++) {
            int numJ = nums[j];
            int numI = numJ * 2;
            int numK = numJ * 2;
            
            // If nums[j] * 2 is within bounds
            if (numI < freq.length) {
                long countI = 0;
                long countK = 0;
                
                // Count valid i's
                for (int i = 0; i < j; i++) {
                    if (nums[i] == numI) {
                        countI++;
                    }
                }
                
                // Count valid k's
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] == numK) {
                        countK++;
                    }
                }
                
                count = (count + (countI * countK) % mod) % mod;
            }
        }
        
        return (int) count;
    }
}