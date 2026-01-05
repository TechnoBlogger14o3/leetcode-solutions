class Solution {
    public int maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long totalSum = 0;
        int minAbsValue = Integer.MAX_VALUE;
        int negativeCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value);
                if (value < 0) {
                    negativeCount++;
                }
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        if (negativeCount % 2 == 0) {
            return (int) totalSum;
        } else {
            return (int) (totalSum - 2 * minAbsValue);
        }
    }
}