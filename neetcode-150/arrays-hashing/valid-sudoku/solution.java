import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(1) - Fixed 9x9 grid, constant time
 * Space Complexity: O(1) - Fixed number of sets
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cell = board[i][j];
                
                if (cell != '.') {
                    // Create keys for row, column, and box
                    String rowKey = "row-" + i + "-" + cell;
                    String colKey = "col-" + j + "-" + cell;
                    String boxKey = "box-" + (i/3) + "-" + (j/3) + "-" + cell;
                    
                    // Check if any key already exists
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}

// Alternative approach using three separate sets
class SolutionThreeSets {
    public boolean isValidSudoku(char[][] board) {
        Set<String> rows = new HashSet<>();
        Set<String> columns = new HashSet<>();
        Set<String> boxes = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cell = board[i][j];
                
                if (cell != '.') {
                    String rowKey = i + "-" + cell;
                    String colKey = j + "-" + cell;
                    String boxKey = (i/3) + "-" + (j/3) + "-" + cell;
                    
                    if (!rows.add(rowKey) || !columns.add(colKey) || !boxes.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}

// Using boolean arrays for tracking
class SolutionBooleanArray {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cell = board[i][j];
                
                if (cell != '.') {
                    int num = cell - '1'; // Convert to 0-8 index
                    int boxIndex = (i/3) * 3 + (j/3);
                    
                    if (rows[i][num] || columns[j][num] || boxes[boxIndex][num]) {
                        return false;
                    }
                    
                    rows[i][num] = true;
                    columns[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }
        
        return true;
    }
}
