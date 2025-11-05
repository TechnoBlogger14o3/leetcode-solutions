import java.util.*;

public class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                countMap.put(nums[j], countMap.getOrDefault(nums[j], 0) + 1);
            }
            
            List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(countMap.entrySet());
            entries.sort((a, b) -> {
                if (b.getValue().equals(a.getValue())) {
                    return b.getKey().compareTo(a.getKey());
                }
                return b.getValue().compareTo(a.getValue());
            });
            
            int sum = 0;
            for (int j = 0; j < Math.min(x, entries.size()); j++) {
                int value = entries.get(j).getKey();
                int count = entries.get(j).getValue();
                sum += value * count;
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}