/**
 * Time Complexity: O(m*n) - Visit each cell once
 * Space Complexity: O(m*n) - Queue size in worst case
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Find all rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // If no fresh oranges, return 0
        if (freshCount == 0) {
            return 0;
        }
        
        int minutes = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // BFS level by level
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotten = false;
            
            // Process all oranges in current level
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                
                // Check all four directions
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                        grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshCount--;
                        hasRotten = true;
                    }
                }
            }
            
            if (hasRotten) {
                minutes++;
            }
        }
        
        return freshCount == 0 ? minutes : -1;
    }
}

// Alternative approach using DFS
class SolutionDFS {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        
        // Count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        if (freshCount == 0) {
            return 0;
        }
        
        int minutes = 0;
        while (freshCount > 0) {
            int prevFreshCount = freshCount;
            freshCount = rotOranges(grid);
            
            if (freshCount == prevFreshCount) {
                return -1; // No more oranges can rot
            }
            
            minutes++;
        }
        
        return minutes;
    }
    
    private int rotOranges(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        
        // First pass: mark oranges that will rot
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (hasRottenNeighbor(grid, i, j)) {
                        grid[i][j] = 3; // Mark as will rot
                    } else {
                        freshCount++;
                    }
                }
            }
        }
        
        // Second pass: actually rot the marked oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 3) {
                    grid[i][j] = 2;
                }
            }
        }
        
        return freshCount;
    }
    
    private boolean hasRottenNeighbor(int[][] grid, int row, int col) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (newRow >= 0 && newRow < grid.length && 
                newCol >= 0 && newCol < grid[0].length && 
                grid[newRow][newCol] == 2) {
                return true;
            }
        }
        
        return false;
    }
}

// Alternative approach using iterative BFS
class SolutionIterative {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        List<int[]> rottenOranges = new ArrayList<>();
        int freshCount = 0;
        
        // Find all rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rottenOranges.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        if (freshCount == 0) {
            return 0;
        }
        
        int minutes = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!rottenOranges.isEmpty()) {
            List<int[]> newRotten = new ArrayList<>();
            
            for (int[] current : rottenOranges) {
                int row = current[0];
                int col = current[1];
                
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                        grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        newRotten.add(new int[]{newRow, newCol});
                        freshCount--;
                    }
                }
            }
            
            if (!newRotten.isEmpty()) {
                minutes++;
            }
            
            rottenOranges = newRotten;
        }
        
        return freshCount == 0 ? minutes : -1;
    }
}

// More concise version
class SolutionConcise {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }
        
        if (fresh == 0) return 0;
        
        int minutes = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotten = false;
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int[] dir : dirs) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];
                    
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                        grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        fresh--;
                        hasRotten = true;
                    }
                }
            }
            
            if (hasRotten) minutes++;
        }
        
        return fresh == 0 ? minutes : -1;
    }
}
