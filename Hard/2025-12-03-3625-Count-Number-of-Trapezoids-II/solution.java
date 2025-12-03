import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        Map<Integer, Map<Integer, Integer>> slopeCount = new HashMap<>();
        int trapezoidCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (points[i][1] != points[j][1]) {
                    int dx = points[j][0] - points[i][0];
                    int dy = points[j][1] - points[i][1];
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;

                    slopeCount.putIfAbsent(dy, new HashMap<>());
                    slopeCount.get(dy).putIfAbsent(dx, 0);
                    slopeCount.get(dy).put(dx, slopeCount.get(dy).get(dx) + 1);
                }
            }
        }

        for (Map<Integer, Integer> map : slopeCount.values()) {
            for (int count : map.values()) {
                if (count >= 2) {
                    trapezoidCount += count * (count - 1) / 2;
                }
            }
        }

        return trapezoidCount;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}