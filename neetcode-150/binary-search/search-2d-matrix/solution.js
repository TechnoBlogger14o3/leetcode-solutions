/**
 * Time Complexity: O(log(mn)) - Binary search on flattened array
 * Space Complexity: O(1) - Only uses constant extra space
 */
var searchMatrix = function(matrix, target) {
    if (!matrix || matrix.length === 0 || matrix[0].length === 0) {
        return false;
    }
    
    const m = matrix.length;
    const n = matrix[0].length;
    let left = 0;
    let right = m * n - 1;
    
    while (left <= right) {
        const mid = Math.floor(left + (right - left) / 2);
        const row = Math.floor(mid / n);
        const col = mid % n;
        
        if (matrix[row][col] === target) {
            return true;
        } else if (matrix[row][col] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return false;
};

// Alternative approach using two binary searches
var searchMatrixTwoBinarySearches = function(matrix, target) {
    if (!matrix || matrix.length === 0 || matrix[0].length === 0) {
        return false;
    }
    
    const m = matrix.length;
    const n = matrix[0].length;
    
    // First binary search: find the correct row
    let top = 0, bottom = m - 1;
    while (top <= bottom) {
        const mid = Math.floor(top + (bottom - top) / 2);
        if (matrix[mid][0] <= target && target <= matrix[mid][n - 1]) {
            // Second binary search: find target in the row
            let left = 0, right = n - 1;
            while (left <= right) {
                const colMid = Math.floor(left + (right - left) / 2);
                if (matrix[mid][colMid] === target) {
                    return true;
                } else if (matrix[mid][colMid] < target) {
                    left = colMid + 1;
                } else {
                    right = colMid - 1;
                }
            }
            return false;
        } else if (matrix[mid][0] > target) {
            bottom = mid - 1;
        } else {
            top = mid + 1;
        }
    }
    
    return false;
};

// Alternative approach using diagonal search
var searchMatrixDiagonal = function(matrix, target) {
    if (!matrix || matrix.length === 0 || matrix[0].length === 0) {
        return false;
    }
    
    let row = 0;
    let col = matrix[0].length - 1;
    
    while (row < matrix.length && col >= 0) {
        if (matrix[row][col] === target) {
            return true;
        } else if (matrix[row][col] > target) {
            col--;
        } else {
            row++;
        }
    }
    
    return false;
};

// More concise version
var searchMatrixConcise = function(matrix, target) {
    if (!matrix.length) return false;
    
    const m = matrix.length, n = matrix[0].length;
    let left = 0, right = m * n - 1;
    
    while (left <= right) {
        const mid = Math.floor(left + (right - left) / 2);
        const val = matrix[Math.floor(mid / n)][mid % n];
        
        if (val === target) return true;
        if (val < target) left = mid + 1;
        else right = mid - 1;
    }
    
    return false;
};

// Using arrow functions
var searchMatrixArrow = function(matrix, target) {
    if (!matrix.length) return false;
    
    const m = matrix.length, n = matrix[0].length;
    const search = (left, right) => {
        if (left > right) return false;
        
        const mid = Math.floor(left + (right - left) / 2);
        const val = matrix[Math.floor(mid / n)][mid % n];
        
        if (val === target) return true;
        if (val < target) return search(mid + 1, right);
        return search(left, mid - 1);
    };
    
    return search(0, m * n - 1);
};
