var canWalk = function(grid, health) {
    const m = grid.length;
    const n = grid[0].length;
    const directions = [[1, 0], [0, 1], [-1, 0], [0, -1]];
    const visited = Array.from({ length: m }, () => Array(n).fill(false));
    
    const dfs = (x, y, remainingHealth) => {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || remainingHealth <= 0) {
            return false;
        }
        if (x === m - 1 && y === n - 1) {
            return true;
        }
        
        visited[x][y] = true;
        remainingHealth -= grid[x][y];
        
        for (const [dx, dy] of directions) {
            if (dfs(x + dx, y + dy, remainingHealth)) {
                return true;
            }
        }
        
        visited[x][y] = false;
        return false;
    };
    
    return dfs(0, 0, health);
};