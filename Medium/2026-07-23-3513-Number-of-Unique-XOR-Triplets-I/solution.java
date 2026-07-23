import java.util.HashSet;

public class Solution {
    public int uniqueTriplets(int[] nums) {
        HashSet<Integer> uniqueXorValues = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int xorValue = nums[i] ^ nums[j] ^ nums[k];
                    uniqueXorValues.add(xorValue);
                }
            }
        }

        return uniqueXorValues.size();
    }
}