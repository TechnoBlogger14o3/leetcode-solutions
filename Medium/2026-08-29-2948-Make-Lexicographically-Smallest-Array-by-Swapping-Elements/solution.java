import java.util.*;

class Solution {
    public int[] smallestArray(int[] nums, int limit) {
        int n = nums.length;
        List<Integer> indices = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            indices.clear();
            int minValue = nums[i];
            indices.add(i);
            visited[i] = true;
            
            for (int j = i + 1; j < n; j++) {
                if (!visited[j] && Math.abs(nums[i] - nums[j]) <= limit) {
                    indices.add(j);
                    visited[j] = true;
                    minValue = Math.min(minValue, nums[j]);
                }
            }
            
            Collections.sort(indices);
            for (int index : indices) {
                result[index] = minValue;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result[i] = nums[i];
            }
        }
        
        return result;
    }
}