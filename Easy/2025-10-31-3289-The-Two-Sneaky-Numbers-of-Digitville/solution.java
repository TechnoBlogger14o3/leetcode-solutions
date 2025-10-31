import java.util.HashMap;

public class Solution {
    public int[] findSneakyNumbers(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        int[] result = new int[2];
        int index = 0;
        for (int key : countMap.keySet()) {
            if (countMap.get(key) == 2) {
                result[index++] = key;
            }
        }
        
        return result;
    }
}