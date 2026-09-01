import java.util.*;

public class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int minimumMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length;
        int startX = 0, startY = 0;
        List<int[]> litterPositions = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                } else if (classroom[i].charAt(j) == 'L') {
                    litterPositions.add(new int[]{i, j});
                }
            }
        }
        
        int totalLitter = litterPositions.size();
        int[][][] dp = new int[totalLitter + 1][m][n];
        for (int[][] grid : dp) {
            for (int[] row : grid) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        
        dp[0][startX][startY] = 0;
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(startX, startY, energy, 0));
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            int x = current.x, y = current.y, currEnergy = current.energy, moves = current.moves;
            
            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0], newY = y + dir[1];
                
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    char cell = classroom[newX].charAt(newY);
                    if (cell == 'X') continue;
                    
                    int newEnergy = currEnergy - 1;
                    if (cell == 'R') newEnergy = energy;
                    
                    if (newEnergy >= 0) {
                        int litterIndex = findLitterIndex(litterPositions, newX, newY);
                        if (litterIndex != -1) {
                            if (dp[litterIndex + 1][newX][newY] > moves + 1) {
                                dp[litterIndex + 1][newX][newY] = moves + 1;
                                queue.offer(new State(newX, newY, newEnergy, moves + 1));
                            }
                        } else {
                            if (dp[0][newX][newY] > moves + 1) {
                                dp[0][newX][newY] = moves + 1;
                                queue.offer(new State(newX, newY, newEnergy, moves + 1));
                            }
                        }
                    }
                }
            }
        }
        
        int minMoves = Integer.MAX_VALUE;
        for (int i = 0; i <= totalLitter; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (dp[i][j][k] < Integer.MAX_VALUE) {
                        minMoves = Math.min(minMoves, dp[i][j][k]);
                    }
                }
            }
        }
        
        return minMoves == Integer.MAX_VALUE ? -1 : minMoves;
    }
    
    private int findLitterIndex(List<int[]> litterPositions, int x, int y) {
        for (int i = 0; i < litterPositions.size(); i++) {
            if (litterPositions.get(i)[0] == x && litterPositions.get(i)[1] == y) {
                return i;
            }
        }
        return -1;
    }
    
    private static class State {
        int x, y, energy, moves;
        
        State(int x, int y, int energy, int moves) {
            this.x = x;
            this.y = y;
            this.energy = energy;
            this.moves = moves;
        }
    }
}