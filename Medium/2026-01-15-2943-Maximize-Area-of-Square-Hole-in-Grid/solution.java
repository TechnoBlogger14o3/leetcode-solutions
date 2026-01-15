import java.util.Arrays;

public class Solution {
    public int maxArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        
        int maxH = Math.max(hBars[0] - 1, n + 1 - hBars[hBars.length - 1]);
        for (int i = 1; i < hBars.length; i++) {
            maxH = Math.max(maxH, hBars[i] - hBars[i - 1]);
        }
        
        int maxV = Math.max(vBars[0] - 1, m + 1 - vBars[vBars.length - 1]);
        for (int i = 1; i < vBars.length; i++) {
            maxV = Math.max(maxV, vBars[i] - vBars[i - 1]);
        }
        
        return Math.min(maxH, maxV) * Math.min(maxH, maxV);
    }
}