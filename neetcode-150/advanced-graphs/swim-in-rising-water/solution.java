/**
 * Time Complexity: O(n² log(max(grid))) - Binary search + DFS
 * Space Complexity: O(n²) - Recursion stack
 */
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = 0;
        int right = n * n - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canReach(grid, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canReach(int[][] grid, int time) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        return dfs(grid, visited, 0, 0, time);
    }
    
    private boolean dfs(int[][] grid, boolean[][] visited, int row, int col, int time) {
        int n = grid.length;
        
        if (row < 0 || row >= n || col < 0 || col >= n || 
            visited[row][col] || grid[row][col] > time) {
            return false;
        }
        
        if (row == n - 1 && col == n - 1) {
            return true;
        }
        
        visited[row][col] = true;
        
        // Check all four directions
        return dfs(grid, visited, row + 1, col, time) ||
               dfs(grid, visited, row - 1, col, time) ||
               dfs(grid, visited, row, col + 1, time) ||
               dfs(grid, visited, row, col - 1, time);
    }
}

// Alternative approach using Dijkstra's Algorithm
class SolutionDijkstra {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][n];
        
        minHeap.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];
            
            if (row == n - 1 && col == n - 1) {
                return time;
            }
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && 
                    !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    int newTime = Math.max(time, grid[newRow][newCol]);
                    minHeap.offer(new int[]{newRow, newCol, newTime});
                }
            }
        }
        
        return -1; // Should not reach here
    }
}

// Alternative approach using Union Find
class SolutionUnionFind {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int totalCells = n * n;
        
        // Create list of all cells with their elevations
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells.add(new int[]{i, j, grid[i][j]});
            }
        }
        
        // Sort cells by elevation
        cells.sort((a, b) -> a[2] - b[2]);
        
        UnionFind uf = new UnionFind(totalCells);
        boolean[][] added = new boolean[n][n];
        
        for (int[] cell : cells) {
            int row = cell[0];
            int col = cell[1];
            int elevation = cell[2];
            
            added[row][col] = true;
            
            // Connect with adjacent cells that are already added
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && 
                    added[newRow][newCol]) {
                    uf.union(row * n + col, newRow * n + newCol);
                }
            }
            
            // Check if start and end are connected
            if (uf.find(0) == uf.find(totalCells - 1)) {
                return elevation;
            }
        }
        
        return -1; // Should not reach here
    }
    
    private static class UnionFind {
        private int[] parent;
        private int[] rank;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}

// Alternative approach using BFS
class SolutionBFS {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = 0;
        int right = n * n - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canReachBFS(grid, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canReachBFS(int[][] grid, int time) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            
            if (row == n - 1 && col == n - 1) {
                return true;
            }
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && 
                    !visited[newRow][newCol] && grid[newRow][newCol] <= time) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        return false;
    }
}

// More concise version
class SolutionConcise {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = 0, right = n * n - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canReach(grid, mid)) right = mid;
            else left = mid + 1;
        }
        
        return left;
    }
    
    private boolean canReach(int[][] grid, int time) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        return dfs(grid, visited, 0, 0, time);
    }
    
    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j, int time) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] > time) return false;
        
        if (i == n - 1 && j == n - 1) return true;
        
        visited[i][j] = true;
        return dfs(grid, visited, i + 1, j, time) || dfs(grid, visited, i - 1, j, time) ||
               dfs(grid, visited, i, j + 1, time) || dfs(grid, visited, i, j - 1, time);
    }
}
