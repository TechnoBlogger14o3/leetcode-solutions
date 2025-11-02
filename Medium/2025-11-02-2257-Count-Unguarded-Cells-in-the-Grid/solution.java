import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        Set<String> guarded = new HashSet<>();
        Set<String> wallsSet = new HashSet<>();

        for (int[] wall : walls) {
            wallsSet.add(wall[0] + "," + wall[1]);
        }

        for (int[] guard : guards) {
            int r = guard[0], c = guard[1];
            guarded.add(r + "," + c);
            // Check north
            for (int i = r - 1; i >= 0 && !wallsSet.contains((i) + "," + c); i--) {
                guarded.add(i + "," + c);
            }
            // Check south
            for (int i = r + 1; i < m && !wallsSet.contains((i) + "," + c); i++) {
                guarded.add(i + "," + c);
            }
            // Check west
            for (int i = c - 1; i >= 0 && !wallsSet.contains(r + "," + (i)); i--) {
                guarded.add(r + "," + i);
            }
            // Check east
            for (int i = c + 1; i < n && !wallsSet.contains(r + "," + (i)); i++) {
                guarded.add(r + "," + i);
            }
        }

        int totalCells = m * n;
        int guardedCells = guarded.size();
        int occupiedCells = walls.length + guards.length;

        return totalCells - guardedCells - occupiedCells;
    }
}