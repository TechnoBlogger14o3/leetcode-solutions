var containsCycle = function(grid) {
    const m = grid.length;
    const n = grid[0].length;
    const visited = Array.from({ length: m }, () => Array(n).fill(false));
    
    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    
    const dfs = (x, y, px, py, char, depth) => {
        if (visited[x][y]) {
            return depth >= 4;
        }
        
        visited[x][y] = true;
        
        for (const [dx, dy] of directions) {
            const nx = x + dx;
            const ny = y + dy;
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && (nx !== px || ny !== py) && grid[nx][ny] === char) {
                if (dfs(nx, ny, x, y, char, depth + 1)) {
                    return true;
                }
            }
        }
        
        visited[x][y] = false;
        return false;
    };
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (!visited[i][j] && dfs(i, j, -1, -1, grid[i][j], 0)) {
                return true;
            }
        }
    }
    
    return false;
};