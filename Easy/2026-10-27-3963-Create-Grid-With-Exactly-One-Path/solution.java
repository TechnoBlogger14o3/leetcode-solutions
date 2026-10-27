import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> createGrid(int m, int n) {
        List<String> grid = new ArrayList<>();
        
        // Fill the grid with '.' and create the path
        for (int i = 0; i < m; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (i == j && j < n - 1) {
                    row.append('#');
                } else if (i == m - 1 && j == n - 1) {
                    row.append('.');
                } else {
                    row.append('.');
                }
            }
            grid.add(row.toString());
        }
        
        // Adjust the last row to ensure there's exactly one path
        for (int j = 0; j < n - 1; j++) {
            grid.set(m - 1, grid.get(m - 1).substring(0, j) + '#' + grid.get(m - 1).substring(j + 1));
        }
        
        return grid;
    }
}