import java.util.*;

class Solution {
    public int[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int[] arr = new int[n];
        
        for (List<Integer> indices : indexMap.values()) {
            int size = indices.size();
            long totalSum = 0;
            long prefixSum = 0;
            
            for (int i = 0; i < size; i++) {
                int index = indices.get(i);
                arr[index] += (int) (i * index - prefixSum);
                totalSum += index;
                prefixSum += index;
            }
            
            prefixSum = 0;
            for (int i = size - 1; i >= 0; i--) {
                int index = indices.get(i);
                arr[index] += (int) (totalSum - (size - i - 1) * index - prefixSum);
                totalSum -= index;
                prefixSum += index;
            }
        }
        
        return arr;
    }
}