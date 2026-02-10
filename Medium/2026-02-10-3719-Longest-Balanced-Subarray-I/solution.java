import java.util.HashSet;

class Solution {
    public int longestBalancedSubarray(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        
        for (int i = 0; i < n; i++) {
            HashSet<Integer> evenSet = new HashSet<>();
            HashSet<Integer> oddSet = new HashSet<>();
            
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    evenSet.add(nums[j]);
                } else {
                    oddSet.add(nums[j]);
                }
                
                if (evenSet.size() == oddSet.size()) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        
        return maxLength;
    }
}