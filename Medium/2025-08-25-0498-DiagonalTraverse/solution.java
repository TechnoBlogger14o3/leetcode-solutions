import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        
        int m = mat.length;
        int n = mat[0].length;
        
        // Map to group elements by diagonal sum
        Map<Integer, List<Integer>> diagonals = new HashMap<>();
        
        // Group elements by diagonal sum (row + col)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diagonalSum = i + j;
                diagonals.computeIfAbsent(diagonalSum, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }
        
        // Build result array
        int[] result = new int[m * n];
        int index = 0;
        
        // Process diagonals in order
        for (int diagonalSum = 0; diagonalSum <= m + n - 2; diagonalSum++) {
            List<Integer> diagonal = diagonals.get(diagonalSum);
            if (diagonal != null) {
                // Even diagonals go from bottom-left to top-right (reverse order)
                // Odd diagonals go from top-left to bottom-right (normal order)
                if (diagonalSum % 2 == 0) {
                    // Reverse for even diagonals
                    for (int i = diagonal.size() - 1; i >= 0; i--) {
                        result[index++] = diagonal.get(i);
                    }
                } else {
                    // Normal order for odd diagonals
                    for (int num : diagonal) {
                        result[index++] = num;
                    }
                }
            }
        }
        
        return result;
    }
}
