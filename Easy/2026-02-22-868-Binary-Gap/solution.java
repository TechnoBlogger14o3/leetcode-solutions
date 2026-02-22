class Solution {
    public int binaryGap(int n) {
        int lastPosition = -1;
        int maxGap = 0;
        
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                if (lastPosition != -1) {
                    maxGap = Math.max(maxGap, i - lastPosition);
                }
                lastPosition = i;
            }
        }
        
        return maxGap;
    }
}