import java.util.Arrays;

public class Solution {
    public long maximizeHappiness(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long totalHappiness = 0;
        
        for (int i = n - 1; i >= n - k; i--) {
            totalHappiness += happiness[i];
        }
        
        long decrement = 0;
        for (int i = n - k; i >= 0; i--) {
            if (happiness[i] - decrement > 0) {
                totalHappiness += Math.max(0, happiness[i] - decrement);
                decrement++;
            }
        }
        
        return totalHappiness;
    }
}