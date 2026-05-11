import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            String str = Integer.toString(num);
            for (char ch : str.toCharArray()) {
                result.add(ch - '0');
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}