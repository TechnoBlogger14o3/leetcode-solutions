var latestDayToCross = function(row, col, cells) {
    const isValid = (grid) => {
        const visited = Array.from({ length: row }, () => Array(col).fill(false));
        const queue = [];
        
        for (let c = 0; c < col; c++) {
            if (grid[0][c] === 0) {
                queue.push([0, c]);
                visited[0][c] = true;
            }
        }
        
        while (queue.length) {
            const [r, c] = queue.shift();
            if (r === row - 1) return true;
            for (const [dr, dc] of [[1, 0], [-1, 0], [0, 1], [0, -1]]) {
                const nr = r + dr, nc = c + dc;
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && !visited[nr][nc] && grid[nr][nc] === 0) {
                    visited[nr][nc] = true;
                    queue.push([nr, nc]);
                }
            }
        }
        return false;
    };

    let left = 0, right = cells.length - 1, answer = 0;
    
    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        const grid = Array.from({ length: row }, () => Array(col).fill(0));
        
        for (let i = 0; i <= mid; i++) {
            const [r, c] = cells[i];
            grid[r - 1][c - 1] = 1;
        }
        
        if (isValid(grid)) {
            answer = mid + 1;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return answer;
};