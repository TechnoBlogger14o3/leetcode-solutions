import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countTrapezoids(int[][] points) {
        final int MOD = 1000000007;
        Map<Integer, Integer> yCount = new HashMap<>();
        
        // Count the number of points for each y-coordinate
        for (int[] point : points) {
            yCount.put(point[1], yCount.getOrDefault(point[1], 0) + 1);
        }
        
        long result = 0;
        
        // Calculate the number of trapezoids
        for (int count : yCount.values()) {
            if (count >= 2) {
                long ways = (long) count * (count - 1) / 2; // Choose 2 points from count
                result = (result + ways * (ways - 1) / 2) % MOD; // Choose 2 pairs of lines
            }
        }
        
        return (int) result;
    }
}