import java.util.Arrays;

public class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));
        
        int left = 0, right = 2 * side, answer = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlace(points, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }

    private boolean canPlace(int[][] points, int k, int minDist) {
        int count = 1;
        int[] lastPoint = points[0];

        for (int i = 1; i < points.length; i++) {
            if (manhattanDistance(lastPoint, points[i]) >= minDist) {
                count++;
                lastPoint = points[i];
                if (count == k) {
                    return true;
                }
            }
        }
        return false;
    }

    private int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}