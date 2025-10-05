import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0); // Pacific Ocean
            dfs(heights, atlantic, i, n - 1); // Atlantic Ocean
        }
        
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j); // Pacific Ocean
            dfs(heights, atlantic, m - 1, j); // Atlantic Ocean
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] ocean, int i, int j) {
        ocean[i][j] = true;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < heights.length && nj >= 0 && nj < heights[0].length 
                && !ocean[ni][nj] && heights[ni][nj] >= heights[i][j]) {
                dfs(heights, ocean, ni, nj);
            }
        }
    }
}