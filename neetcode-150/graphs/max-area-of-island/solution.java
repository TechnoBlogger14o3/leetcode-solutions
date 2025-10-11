/**
 * Time Complexity: O(m*n) - Visit each cell once
 * Space Complexity: O(m*n) - Recursion stack in worst case
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != 1) {
            return 0;
        }
        
        grid[row][col] = 0; // Mark as visited
        
        return 1 + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) + 
                   dfs(grid, row, col + 1) + dfs(grid, row, col - 1);
    }
}

// Alternative approach using BFS
class SolutionBFS {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
    
    private int bfs(int[][] grid, int startRow, int startCol) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{startRow, startCol});
        grid[startRow][startCol] = 0;
        int area = 1;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                    grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 0;
                    queue.offer(new int[]{newRow, newCol});
                    area++;
                }
            }
        }
        
        return area;
    }
}

// Alternative approach using iterative DFS with stack
class SolutionIterative {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfsIterative(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
    
    private int dfsIterative(int[][] grid, int startRow, int startCol) {
        int m = grid.length;
        int n = grid[0].length;
        Stack<int[]> stack = new Stack<>();
        
        stack.push(new int[]{startRow, startCol});
        grid[startRow][startCol] = 0;
        int area = 1;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                    grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 0;
                    stack.push(new int[]{newRow, newCol});
                    area++;
                }
            }
        }
        
        return area;
    }
}

// Alternative approach using Union Find
class SolutionUnionFind {
    private int[] parent;
    private int[] rank;
    private int[] size;
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int totalCells = m * n;
        
        parent = new int[totalCells];
        rank = new int[totalCells];
        size = new int[totalCells];
        
        // Initialize Union Find
        for (int i = 0; i < totalCells; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = grid[i / n][i % n]; // Initialize size based on grid value
        }
        
        // Union adjacent land cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int current = i * n + j;
                    
                    // Check right neighbor
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        union(current, i * n + j + 1);
                    }
                    
                    // Check bottom neighbor
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        union(current, (i + 1) * n + j);
                    }
                }
            }
        }
        
        // Find maximum area
        int maxArea = 0;
        for (int i = 0; i < totalCells; i++) {
            if (grid[i / n][i % n] == 1) {
                maxArea = Math.max(maxArea, size[find(i)]);
            }
        }
        
        return maxArea;
    }
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
                size[rootX] += size[rootY];
            }
        }
    }
}

// More concise version
class SolutionConcise {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return 0;
        
        grid[i][j] = 0;
        return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }
}
