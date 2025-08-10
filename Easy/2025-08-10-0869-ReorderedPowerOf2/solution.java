import java.util.*;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] count = countDigits(n);
        
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(count, countDigits(1 << i))) {
                return true;
            }
        }
        return false;
    }
    
    private int[] countDigits(int n) {
        int[] count = new int[10];
        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }
        return count;
    }
}
