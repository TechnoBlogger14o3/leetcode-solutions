import java.util.*;

public class Solution {
    public int[] multiplyBySum(String s, int[][] queries) {
        int mod = 1000000007;
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            StringBuilder nonZeroDigits = new StringBuilder();
            int sum = 0;
            
            for (int j = l; j <= r; j++) {
                char digit = s.charAt(j);
                if (digit != '0') {
                    nonZeroDigits.append(digit);
                    sum += digit - '0';
                }
            }
            
            long x = nonZeroDigits.length() > 0 ? Long.parseLong(nonZeroDigits.toString()) : 0;
            result[i] = (int) ((x * sum) % mod);
        }
        
        return result;
    }
}