/**
 * Time Complexity: O(1) - Fixed 9x9 grid, constant time
 * Space Complexity: O(1) - Fixed number of sets
 */
var isValidSudoku = function(board) {
    const seen = new Set();
    
    for (let i = 0; i < 9; i++) {
        for (let j = 0; j < 9; j++) {
            const cell = board[i][j];
            
            if (cell !== '.') {
                // Create keys for row, column, and box
                const rowKey = `row-${i}-${cell}`;
                const colKey = `col-${j}-${cell}`;
                const boxKey = `box-${Math.floor(i/3)}-${Math.floor(j/3)}-${cell}`;
                
                // Check if any key already exists
                if (seen.has(rowKey) || seen.has(colKey) || seen.has(boxKey)) {
                    return false;
                }
                
                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);
            }
        }
    }
    
    return true;
};

// Alternative approach using three separate sets
var isValidSudokuThreeSets = function(board) {
    const rows = new Set();
    const columns = new Set();
    const boxes = new Set();
    
    for (let i = 0; i < 9; i++) {
        for (let j = 0; j < 9; j++) {
            const cell = board[i][j];
            
            if (cell !== '.') {
                const rowKey = `${i}-${cell}`;
                const colKey = `${j}-${cell}`;
                const boxKey = `${Math.floor(i/3)}-${Math.floor(j/3)}-${cell}`;
                
                if (rows.has(rowKey) || columns.has(colKey) || boxes.has(boxKey)) {
                    return false;
                }
                
                rows.add(rowKey);
                columns.add(colKey);
                boxes.add(boxKey);
            }
        }
    }
    
    return true;
};

// Using boolean arrays for tracking
var isValidSudokuBooleanArray = function(board) {
    const rows = Array(9).fill().map(() => Array(9).fill(false));
    const columns = Array(9).fill().map(() => Array(9).fill(false));
    const boxes = Array(9).fill().map(() => Array(9).fill(false));
    
    for (let i = 0; i < 9; i++) {
        for (let j = 0; j < 9; j++) {
            const cell = board[i][j];
            
            if (cell !== '.') {
                const num = cell.charCodeAt(0) - '1'.charCodeAt(0); // Convert to 0-8 index
                const boxIndex = Math.floor(i/3) * 3 + Math.floor(j/3);
                
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
};
