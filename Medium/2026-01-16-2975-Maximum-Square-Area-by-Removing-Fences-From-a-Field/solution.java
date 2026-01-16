import java.util.Arrays;

public class Solution {
    public int maxSquare(int m, int n, int[] hFences, int[] vFences) {
        final int MOD = 1000000007;
        
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        
        int maxHeight = 0;
        int maxWidth = 0;
        
        // Calculate maximum height between horizontal fences
        maxHeight = Math.max(hFences[0] - 1, m - hFences[hFences.length - 1]);
        for (int i = 1; i < hFences.length; i++) {
            maxHeight = Math.max(maxHeight, hFences[i] - hFences[i - 1]);
        }
        
        // Calculate maximum width between vertical fences
        maxWidth = Math.max(vFences[0] - 1, n - vFences[vFences.length - 1]);
        for (int i = 1; i < vFences.length; i++) {
            maxWidth = Math.max(maxWidth, vFences[i] - vFences[i - 1]);
        }
        
        int maxSide = Math.min(maxHeight, maxWidth);
        if (maxSide < 1) {
            return -1;
        }
        
        return (int)((long)maxSide * maxSide % MOD);
    }
}