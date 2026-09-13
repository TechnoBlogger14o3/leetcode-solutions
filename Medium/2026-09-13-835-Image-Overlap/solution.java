class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;

        for (int xShift = -n + 1; xShift < n; xShift++) {
            for (int yShift = -n + 1; yShift < n; yShift++) {
                maxOverlap = Math.max(maxOverlap, countOverlap(img1, img2, xShift, yShift));
            }
        }

        return maxOverlap;
    }

    private int countOverlap(int[][] img1, int[][] img2, int xShift, int yShift) {
        int overlap = 0;
        int n = img1.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + xShift >= 0 && i + xShift < n && j + yShift >= 0 && j + yShift < n) {
                    overlap += img1[i][j] * img2[i + xShift][j + yShift];
                }
            }
        }

        return overlap;
    }
}