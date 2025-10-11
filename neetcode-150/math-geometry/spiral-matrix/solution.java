/**
 * Time Complexity: O(m * n) - Visit each element once
 * Space Complexity: O(1) - Excluding output array
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix.length == 0) {
            return result;
        }
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse top row
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            
            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // Traverse bottom row (if exists)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }
            
            // Traverse left column (if exists)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}

// Alternative approach using direction array
class SolutionDirectionArray {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix.length == 0) {
            return result;
        }
        
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int x = 0, y = 0, dir = 0;
        
        for (int i = 0; i < m * n; i++) {
            result.add(matrix[x][y]);
            visited[x][y] = true;
            
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];
            
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY]) {
                dir = (dir + 1) % 4;
                nextX = x + dx[dir];
                nextY = y + dy[dir];
            }
            
            x = nextX;
            y = nextY;
        }
        
        return result;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix.length == 0) {
            return result;
        }
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Top row
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            
            // Right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // Bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }
            
            // Left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix.length == 0) {
            return result;
        }
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Top row
            int j = left;
            while (j <= right) {
                result.add(matrix[top][j]);
                j++;
            }
            top++;
            
            // Right column
            int i = top;
            while (i <= bottom) {
                result.add(matrix[i][right]);
                i++;
            }
            right--;
            
            // Bottom row
            if (top <= bottom) {
                j = right;
                while (j >= left) {
                    result.add(matrix[bottom][j]);
                    j--;
                }
                bottom--;
            }
            
            // Left column
            if (left <= right) {
                i = bottom;
                while (i >= top) {
                    result.add(matrix[i][left]);
                    i--;
                }
                left++;
            }
        }
        
        return result;
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix.length == 0) {
            return result;
        }
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Top row
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            
            // Right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // Bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }
            
            // Left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}

// More concise version
class SolutionConcise {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) result.add(matrix[top][j]);
            top++;
            
            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;
            
            if (top <= bottom) {
                for (int j = right; j >= left; j--) result.add(matrix[bottom][j]);
                bottom--;
            }
            
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }
        
        return result;
    }
}
