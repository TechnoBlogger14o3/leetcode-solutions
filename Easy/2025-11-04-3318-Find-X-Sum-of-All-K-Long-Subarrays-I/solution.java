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
            
            List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
            entryList.sort((a, b) -> {
                if (b.getValue().equals(a.getValue())) {
                    return b.getKey() - a.getKey();
                }
                return b.getValue() - a.getValue();
            });
            
            int sum = 0;
            for (int j = 0; j < Math.min(x, entryList.size()); j++) {
                int num = entryList.get(j).getKey();
                int freq = entryList.get(j).getValue();
                sum += num * freq;
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}