var countUnguarded = function(m, n, guards, walls) {
    const grid = Array.from({ length: m }, () => Array(n).fill(0));
    
    for (const [r, c] of guards) {
        grid[r][c] = 1; // Mark guards
    }
    
    for (const [r, c] of walls) {
        grid[r][c] = 2; // Mark walls
    }
    
    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    
    for (const [r, c] of guards) {
        for (const [dr, dc] of directions) {
            let nr = r + dr;
            let nc = c + dc;
            while (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] === 0) {
                grid[nr][nc] = 3; // Mark guarded cells
                nr += dr;
                nc += dc;
            }
        }
    }
    
    let unguardedCount = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 0) {
                unguardedCount++;
            }
        }
    }
    
    return unguardedCount;
};