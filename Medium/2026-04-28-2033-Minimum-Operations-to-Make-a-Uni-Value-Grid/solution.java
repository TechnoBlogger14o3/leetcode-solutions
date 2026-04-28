class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int totalElements = m * n;
        int[] values = new int[totalElements];
        int index = 0;

        for (int[] row : grid) {
            for (int value : row) {
                values[index++] = value;
            }
        }

        Arrays.sort(values);
        int median = values[totalElements / 2];
        int operations = 0;

        for (int value : values) {
            int diff = Math.abs(value - median);
            if (diff % x != 0) {
                return -1;
            }
            operations += diff / x;
        }

        return operations;
    }
}