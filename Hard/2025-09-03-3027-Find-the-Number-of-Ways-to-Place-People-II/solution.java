import java.util.Arrays;

public class Solution {
    public int countWays(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (points[i][0] < points[j][0] && points[i][1] > points[j][1]) {
                    count++;
                }
            }
        }
        return count;
    }
}