class Solution {
    public int countSubmatrices(String[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;

        for (int top = 0; top < m; top++) {
            int[] freq = new int[2]; // freq[0] for 'X', freq[1] for 'Y'
            for (int bottom = top; bottom < m; bottom++) {
                for (int j = 0; j < n; j++) {
                    if (grid[bottom][j].equals("X")) {
                        freq[0]++;
                    } else if (grid[bottom][j].equals("Y")) {
                        freq[1]++;
                    }
                }

                for (int j = 0; j < n; j++) {
                    if (grid[bottom][j].equals("X") || grid[bottom][j].equals("Y")) {
                        int xCount = 0, yCount = 0;
                        for (int k = j; k < n; k++) {
                            if (grid[bottom][k].equals("X")) {
                                xCount++;
                            } else if (grid[bottom][k].equals("Y")) {
                                yCount++;
                            }
                            if (xCount > 0 && xCount == yCount) {
                                count++;
                            }
                            if (grid[bottom][k].equals(".")) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}