import java.util.*;

public class Solution {
    public int[] findXValue(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            
            // Update the nums array
            nums[index] = value;
            
            // Calculate the product modulo k
            long product = 1;
            int count = 0;
            for (int j = start; j < n; j++) {
                product = (product * nums[j]) % k;
                if (product == x) {
                    count++;
                }
            }
            result[i] = count;
        }
        
        return result;
    }
}