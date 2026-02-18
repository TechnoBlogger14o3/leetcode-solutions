public class Solution {
    public boolean hasAlternatingBits(int n) {
        int lastBit = n & 1;
        n >>= 1;
        
        while (n > 0) {
            int currentBit = n & 1;
            if (currentBit == lastBit) {
                return false;
            }
            lastBit = currentBit;
            n >>= 1;
        }
        
        return true;
    }
}