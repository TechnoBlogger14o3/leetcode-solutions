/**
 * Time Complexity: O(m*n) - Visit each cell once
 * Space Complexity: O(m*n) - Recursion stack in worst case
 */
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        // DFS from boundary cells with 'O'
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }
        
        // Convert remaining 'O's to 'X' and 'T's back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'O') {
            return;
        }
        
        board[row][col] = 'T'; // Mark as temporary
        
        // Explore all four directions
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}

// Alternative approach using BFS
class SolutionBFS {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Add boundary cells with 'O' to queue
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                board[i][0] = 'T';
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(new int[]{i, n - 1});
                board[i][n - 1] = 'T';
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                queue.offer(new int[]{0, j});
                board[0][j] = 'T';
            }
            if (board[m - 1][j] == 'O') {
                queue.offer(new int[]{m - 1, j});
                board[m - 1][j] = 'T';
            }
        }
        
        // BFS to mark all connected 'O's as 'T'
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                    board[newRow][newCol] == 'O') {
                    board[newRow][newCol] = 'T';
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        // Convert remaining 'O's to 'X' and 'T's back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}

// Alternative approach using iterative DFS with stack
class SolutionIterative {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        // DFS from boundary cells with 'O'
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfsIterative(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfsIterative(board, i, n - 1);
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfsIterative(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfsIterative(board, m - 1, j);
            }
        }
        
        // Convert remaining 'O's to 'X' and 'T's back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfsIterative(char[][] board, int startRow, int startCol) {
        int m = board.length;
        int n = board[0].length;
        Stack<int[]> stack = new Stack<>();
        
        stack.push(new int[]{startRow, startCol});
        board[startRow][startCol] = 'T';
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                    board[newRow][newCol] == 'O') {
                    board[newRow][newCol] = 'T';
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }
    }
}

// More concise version
class SolutionConcise {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int m = board.length, n = board[0].length;
        
        // DFS from boundaries
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j);
        }
        
        // Convert
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        
        board[i][j] = 'T';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
