import java.util.*;

class Solution {
    public int countPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && points[i][0] < points[j][0] && points[i][1] < points[j][1]) {
                    if (isRectangleEmpty(points, points[i], points[j])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isRectangleEmpty(int[][] points, int[] A, int[] B) {
        for (int[] point : points) {
            if (point != A && point != B) {
                if (point[0] > A[0] && point[0] < B[0] && point[1] > A[1] && point[1] < B[1]) {
                    return false;
                }
            }
        }
        return true;
    }
}