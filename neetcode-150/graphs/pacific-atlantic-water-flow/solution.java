/**
 * Time Complexity: O(m*n) - Visit each cell once
 * Space Complexity: O(m*n) - Visited arrays
 */
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return new ArrayList<>();
        }
        
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // DFS from Pacific Ocean boundaries (left and top edges)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
        }
        
        // DFS from Atlantic Ocean boundaries (right and bottom edges)
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1, Integer.MIN_VALUE);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, atlantic, m - 1, j, Integer.MIN_VALUE);
        }
        
        // Find cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] visited, int row, int col, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;
        
        if (row < 0 || row >= m || col < 0 || col >= n || 
            visited[row][col] || heights[row][col] < prevHeight) {
            return;
        }
        
        visited[row][col] = true;
        
        // Explore all four directions
        dfs(heights, visited, row + 1, col, heights[row][col]);
        dfs(heights, visited, row - 1, col, heights[row][col]);
        dfs(heights, visited, row, col + 1, heights[row][col]);
        dfs(heights, visited, row, col - 1, heights[row][col]);
    }
}

// Alternative approach using BFS
class SolutionBFS {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return new ArrayList<>();
        }
        
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // BFS from Pacific Ocean boundaries
        Queue<int[]> pacificQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            pacificQueue.offer(new int[]{i, 0});
            pacific[i][0] = true;
        }
        for (int j = 0; j < n; j++) {
            pacificQueue.offer(new int[]{0, j});
            pacific[0][j] = true;
        }
        bfs(heights, pacific, pacificQueue);
        
        // BFS from Atlantic Ocean boundaries
        Queue<int[]> atlanticQueue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            atlanticQueue.offer(new int[]{i, n - 1});
            atlantic[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            atlanticQueue.offer(new int[]{m - 1, j});
            atlantic[m - 1][j] = true;
        }
        bfs(heights, atlantic, atlanticQueue);
        
        // Find cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < heights.length && 
                    newCol >= 0 && newCol < heights[0].length && 
                    !visited[newRow][newCol] && 
                    heights[newRow][newCol] >= heights[row][col]) {
                    
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}

// Alternative approach using iterative DFS with stack
class SolutionIterative {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return new ArrayList<>();
        }
        
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // DFS from Pacific Ocean boundaries
        for (int i = 0; i < m; i++) {
            dfsIterative(heights, pacific, i, 0);
        }
        for (int j = 0; j < n; j++) {
            dfsIterative(heights, pacific, 0, j);
        }
        
        // DFS from Atlantic Ocean boundaries
        for (int i = 0; i < m; i++) {
            dfsIterative(heights, atlantic, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfsIterative(heights, atlantic, m - 1, j);
        }
        
        // Find cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfsIterative(int[][] heights, boolean[][] visited, int startRow, int startCol) {
        int m = heights.length;
        int n = heights[0].length;
        Stack<int[]> stack = new Stack<>();
        
        stack.push(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                    !visited[newRow][newCol] && 
                    heights[newRow][newCol] >= heights[row][col]) {
                    
                    visited[newRow][newCol] = true;
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }
    }
}

// More concise version
class SolutionConcise {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) return new ArrayList<>();
        
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // DFS from Pacific boundaries
        for (int i = 0; i < m; i++) dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
        for (int j = 0; j < n; j++) dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
        
        // DFS from Atlantic boundaries
        for (int i = 0; i < m; i++) dfs(heights, atlantic, i, n - 1, Integer.MIN_VALUE);
        for (int j = 0; j < n; j++) dfs(heights, atlantic, m - 1, j, Integer.MIN_VALUE);
        
        // Find intersection
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] visited, int i, int j, int prev) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || 
            visited[i][j] || heights[i][j] < prev) return;
        
        visited[i][j] = true;
        dfs(heights, visited, i + 1, j, heights[i][j]);
        dfs(heights, visited, i - 1, j, heights[i][j]);
        dfs(heights, visited, i, j + 1, heights[i][j]);
        dfs(heights, visited, i, j - 1, heights[i][j]);
    }
}
