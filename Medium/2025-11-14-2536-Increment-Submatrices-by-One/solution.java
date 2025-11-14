class Solution {
    public int[][] incrementSubmatrices(int n, int[][] queries) {
        int[][] mat = new int[n][n];

        for (int[] query : queries) {
            int row1 = query[0], col1 = query[1], row2 = query[2], col2 = query[3];
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    mat[i][j]++;
                }
            }
        }

        return mat;
    }
}