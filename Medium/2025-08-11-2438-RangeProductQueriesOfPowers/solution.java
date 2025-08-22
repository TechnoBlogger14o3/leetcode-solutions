import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int MOD = 1000000007;
    
    public int[] productQueries(int n, int[][] queries) {
        // Generate powers array
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
            }
        }
        
        // Compute prefix products
        int[] prefix = new int[powers.size()];
        prefix[0] = powers.get(0);
        for (int i = 1; i < powers.size(); i++) {
            prefix[i] = (int)((long)prefix[i-1] * powers.get(i) % MOD);
        }
        
        // Process queries
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            if (left == 0) {
                answer[i] = prefix[right];
            } else {
                answer[i] = (int)((long)prefix[right] * modInverse(prefix[left-1]) % MOD);
            }
        }
        
        return answer;
    }
    
    private int modInverse(int a) {
        return modPow(a, MOD - 2);
    }
    
    private int modPow(int base, int exp) {
        long result = 1;
        long b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % MOD;
            }
            b = (b * b) % MOD;
            exp >>= 1;
        }
        return (int)result;
    }
}
