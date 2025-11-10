import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> uniqueNonZero = new HashSet<>();
        for (int num : nums) {
            if (num != 0) {
                uniqueNonZero.add(num);
            }
        }
        return uniqueNonZero.size();
    }
}