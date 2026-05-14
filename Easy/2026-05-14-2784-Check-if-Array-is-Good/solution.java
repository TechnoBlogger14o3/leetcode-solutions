import java.util.HashMap;

class Solution {
    public boolean isGoodArray(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n = Math.max(n, num);
        }
        
        if (nums.length != n + 1) {
            return false;
        }
        
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        for (int i = 1; i < n; i++) {
            if (countMap.getOrDefault(i, 0) != 1) {
                return false;
            }
        }
        
        return countMap.getOrDefault(n, 0) == 2;
    }
}