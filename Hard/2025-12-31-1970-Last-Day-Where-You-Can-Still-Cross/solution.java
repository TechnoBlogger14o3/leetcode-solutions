class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = cells.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (canCross(row, col, cells, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) {
        boolean[][] grid = new boolean[row][col];
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = true;
        }
        
        boolean[] visited = new boolean[col];
        for (int j = 0; j < col; j++) {
            if (!grid[0][j]) {
                visited[j] = true;
            }
        }

        for (int i = 0; i < row; i++) {
            boolean[] newVisited = new boolean[col];
            for (int j = 0; j < col; j++) {
                if (visited[j] && !grid[i][j]) {
                    newVisited[j] = true;
                    if (i == row - 1) {
                        return true;
                    }
                    if (j > 0 && !grid[i][j - 1]) {
                        newVisited[j - 1] = true;
                    }
                    if (j < col - 1 && !grid[i][j + 1]) {
                        newVisited[j + 1] = true;
                    }
                    if (i < row - 1 && !grid[i + 1][j]) {
                        newVisited[j] = true;
                    }
                }
            }
            visited = newVisited;
        }
        return false;
    }
}