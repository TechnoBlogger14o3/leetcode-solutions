java
import java.util.*;

class Solution {
    public int[][] diagonalSort(int[][] grid) {
        int n = grid.length;
        Map<Integer, PriorityQueue<Integer>> diagMap = new HashMap<>();

        // Collect elements in diagonals for bottom-left triangle
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                diagMap.computeIfAbsent(i - j, k -> new PriorityQueue<>(Collections.reverseOrder())).offer(grid[i][j]);
            }
        }

        // Replace elements in bottom-left triangle with sorted values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                grid[i][j] = diagMap.get(i - j).poll();
            }
        }

        diagMap.clear();

        // Collect elements in diagonals for top-right triangle
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                diagMap.computeIfAbsent(j - i, k -> new PriorityQueue<>()).offer(grid[i][j]);
            }
        }

        // Replace elements in top-right triangle with sorted values
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                grid[i][j] = diagMap.get(j - i).poll();
            }
        }

        return grid;
    }
}