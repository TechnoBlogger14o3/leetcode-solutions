import java.util.HashSet;

public class Solution {
    public int uniqueXORTriplets(int[] nums) {
        HashSet<Integer> uniqueXORs = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int xorValue = nums[i] ^ nums[j] ^ nums[k];
                    uniqueXORs.add(xorValue);
                }
            }
        }

        return uniqueXORs.size();
    }
}