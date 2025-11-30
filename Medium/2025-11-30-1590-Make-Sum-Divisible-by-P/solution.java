class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        long remainder = totalSum % p;
        if (remainder == 0) return 0;
        
        int n = nums.length;
        Map<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, -1);
        long currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            long target = (currentSum % p - remainder + p) % p;
            if (prefixMap.containsKey(target)) {
                minLength = Math.min(minLength, i - prefixMap.get(target));
            }
            prefixMap.put(currentSum % p, i);
        }
        
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}