import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumAbsDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {
            int reversed = reverse(nums[i]);
            if (map.containsKey(reversed)) {
                found = true;
                minDistance = Math.min(minDistance, i - map.get(reversed));
            }
            map.put(nums[i], i);
        }

        return found ? minDistance : -1;
    }

    private int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}