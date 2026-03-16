import java.util.*;

public class Solution {
    public int[] getBiggestThree(int[][] grid) {
        Set<Integer> rhombusSums = new HashSet<>();
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < Math.min(m, n); d++) {
                    int sum = 0;
                    boolean valid = true;
                    for (int k = 0; k <= d; k++) {
                        if (i + k < m && j - d + k >= 0) sum += grid[i + k][j - d + k];
                        else valid = false;
                        if (i + k < m && j + d - k < n) sum += grid[i + k][j + d - k];
                        else valid = false;
                        if (k > 0) {
                            if (i - k >= 0 && j - d + k >= 0) sum += grid[i - k][j - d + k];
                            else valid = false;
                            if (i - k >= 0 && j + d - k < n) sum += grid[i - k][j + d - k];
                            else valid = false;
                        }
                    }
                    if (valid) rhombusSums.add(sum);
                }
            }
        }

        List<Integer> sortedSums = new ArrayList<>(rhombusSums);
        Collections.sort(sortedSums, Collections.reverseOrder());
        
        int size = Math.min(3, sortedSums.size());
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = sortedSums.get(i);
        }
        
        return result;
    }
}