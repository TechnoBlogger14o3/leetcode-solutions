/**
 * Time Complexity: O(m*n) - Visit each cell once
 * Space Complexity: O(m*n) - Queue size in worst case
 */
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Add all gates to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // BFS level by level
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            
            // Check all four directions
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                    rooms[newRow][newCol] == Integer.MAX_VALUE) {
                    rooms[newRow][newCol] = rooms[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}

// Alternative approach using DFS
class SolutionDFS {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        
        int m = rooms.length;
        int n = rooms[0].length;
        
        // DFS from each gate
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    private void dfs(int[][] rooms, int row, int col, int distance) {
        int m = rooms.length;
        int n = rooms[0].length;
        
        if (row < 0 || row >= m || col < 0 || col >= n || 
            rooms[row][col] < distance) {
            return;
        }
        
        rooms[row][col] = distance;
        
        // Explore all four directions
        dfs(rooms, row + 1, col, distance + 1);
        dfs(rooms, row - 1, col, distance + 1);
        dfs(rooms, row, col + 1, distance + 1);
        dfs(rooms, row, col - 1, distance + 1);
    }
}

// Alternative approach using iterative BFS
class SolutionIterative {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        
        int m = rooms.length;
        int n = rooms[0].length;
        List<int[]> gates = new ArrayList<>();
        
        // Find all gates
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    gates.add(new int[]{i, j});
                }
            }
        }
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // BFS from each gate
        for (int[] gate : gates) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(gate);
            
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                        rooms[newRow][newCol] > rooms[row][col] + 1) {
                        rooms[newRow][newCol] = rooms[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
    }
}

// More concise version
class SolutionConcise {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Add all gates to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (int[] dir : dirs) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                    rooms[newRow][newCol] == Integer.MAX_VALUE) {
                    rooms[newRow][newCol] = rooms[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
