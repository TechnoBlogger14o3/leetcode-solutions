/**
 * Time Complexity: O(m*n*4^L) - L is length of word
 * Space Complexity: O(L) - Recursion stack depth
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) {
            return true;
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        
        // Mark cell as visited
        char temp = board[row][col];
        board[row][col] = '#';
        
        // Explore all four directions
        boolean found = dfs(board, word, index + 1, row + 1, col) ||
                       dfs(board, word, index + 1, row - 1, col) ||
                       dfs(board, word, index + 1, row, col + 1) ||
                       dfs(board, word, index + 1, row, col - 1);
        
        // Backtrack
        board[row][col] = temp;
        
        return found;
    }
}

// Alternative approach using iterative method with stack
class SolutionIterative {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfsIterative(board, word, i, j)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean dfsIterative(char[][] board, String word, int startRow, int startCol) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startRow, startCol, 0});
        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int row = current[0];
            int col = current[1];
            int index = current[2];
            
            if (index == word.length()) {
                return true;
            }
            
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
                continue;
            }
            
            if (board[row][col] != word.charAt(index)) {
                continue;
            }
            
            // Mark cell as visited
            char temp = board[row][col];
            board[row][col] = '#';
            
            // Add all four directions to stack
            stack.push(new int[]{row + 1, col, index + 1});
            stack.push(new int[]{row - 1, col, index + 1});
            stack.push(new int[]{row, col + 1, index + 1});
            stack.push(new int[]{row, col - 1, index + 1});
            
            // Restore cell
            board[row][col] = temp;
        }
        
        return false;
    }
}

// Alternative approach using visited array
class SolutionVisited {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        
        if (visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        visited[row][col] = true;
        
        boolean found = dfs(board, word, index + 1, row + 1, col, visited) ||
                       dfs(board, word, index + 1, row - 1, col, visited) ||
                       dfs(board, word, index + 1, row, col + 1, visited) ||
                       dfs(board, word, index + 1, row, col - 1, visited);
        
        visited[row][col] = false;
        
        return found;
    }
}

// More concise version
class SolutionConcise {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (board[row][col] != word.charAt(index)) return false;
        
        char temp = board[row][col];
        board[row][col] = '#';
        
        boolean found = dfs(board, word, index + 1, row + 1, col) ||
                       dfs(board, word, index + 1, row - 1, col) ||
                       dfs(board, word, index + 1, row, col + 1) ||
                       dfs(board, word, index + 1, row, col - 1);
        
        board[row][col] = temp;
        return found;
    }
}

// Using directions array
class SolutionDirections {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) {
            return true;
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        
        char temp = board[row][col];
        board[row][col] = '#';
        
        for (int[] dir : DIRECTIONS) {
            if (dfs(board, word, index + 1, row + dir[0], col + dir[1])) {
                return true;
            }
        }
        
        board[row][col] = temp;
        return false;
    }
}
