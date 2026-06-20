import java.util.Arrays;

public class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        // Add the first and last building restrictions
        restrictions = Arrays.copyOf(restrictions, restrictions.length + 2);
        restrictions[restrictions.length - 2] = new int[]{1, 0};
        restrictions[restrictions.length - 1] = new int[]{n, 0};
        
        // Sort restrictions by building id
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        
        // Apply the restrictions to calculate max heights
        int m = restrictions.length;
        for (int i = 1; i < m; i++) {
            int idDiff = restrictions[i][0] - restrictions[i - 1][0];
            int heightDiff = restrictions[i][1] - restrictions[i - 1][1];
            int maxHeight = Math.max(0, heightDiff + idDiff);
            restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i - 1][1] + idDiff);
            restrictions[i][1] = Math.max(restrictions[i][1], restrictions[i - 1][1] - idDiff);
        }
        
        // Calculate the maximum height
        int maxHeight = 0;
        for (int i = 1; i < m; i++) {
            int idDiff = restrictions[i][0] - restrictions[i - 1][0];
            int height = (restrictions[i][1] + restrictions[i - 1][1] + idDiff) / 2;
            maxHeight = Math.max(maxHeight, height);
        }
        
        // Consider the last building
        maxHeight = Math.max(maxHeight, restrictions[m - 1][1] + (n - restrictions[m - 1][0]));
        
        return maxHeight;
    }
}