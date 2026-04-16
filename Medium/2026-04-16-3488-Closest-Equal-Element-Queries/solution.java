import java.util.*;

public class Solution {
    public int[] closestEqualElementQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        int n = nums.length;
        
        // Populate the index map with positions of each number
        for (int i = 0; i < n; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int queryIndex = queries[i];
            int value = nums[queryIndex];
            List<Integer> positions = indexMap.get(value);
            
            if (positions.size() <= 1) {
                answer[i] = -1;
                continue;
            }
            
            int minDistance = Integer.MAX_VALUE;
            for (int pos : positions) {
                if (pos != queryIndex) {
                    int distance = Math.abs(pos - queryIndex);
                    distance = Math.min(distance, n - distance); // Circular distance
                    minDistance = Math.min(minDistance, distance);
                }
            }
            answer[i] = minDistance;
        }
        
        return answer;
    }
}