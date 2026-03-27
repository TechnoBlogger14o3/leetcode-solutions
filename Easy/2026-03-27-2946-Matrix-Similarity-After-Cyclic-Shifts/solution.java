class Solution {
    public boolean canBeEqual(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // Normalize k to be within the bounds of the row length
        k = k % n;

        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                // Even indexed rows shift left
                if (!isEqual(mat[i], shiftLeft(mat[i], k))) {
                    return false;
                }
            } else {
                // Odd indexed rows shift right
                if (!isEqual(mat[i], shiftRight(mat[i], k))) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] shiftLeft(int[] row, int k) {
        int n = row.length;
        int[] shifted = new int[n];
        for (int i = 0; i < n; i++) {
            shifted[i] = row[(i + k) % n];
        }
        return shifted;
    }

    private int[] shiftRight(int[] row, int k) {
        int n = row.length;
        int[] shifted = new int[n];
        for (int i = 0; i < n; i++) {
            shifted[i] = row[(i - k + n) % n];
        }
        return shifted;
    }

    private boolean isEqual(int[] row1, int[] row2) {
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] != row2[i]) {
                return false;
            }
        }
        return true;
    }
}