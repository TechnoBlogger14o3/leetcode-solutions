var closedIsland = function(grid) {
    const rows = grid.length;
    const cols = grid[0].length;
    
    const dfs = (r, c) => {
        if (r < 0 || r >= rows || c < 0 || c >= cols) return true;
        if (grid[r][c] === 1) return true;
        if (grid[r][c] === -1) return false;

        grid[r][c] = -1; // mark as visited
        let top = dfs(r - 1, c);
        let bottom = dfs(r + 1, c);
        let left = dfs(r, c - 1);
        let right = dfs(r, c + 1);
        
        return top && bottom && left && right;
    };

    let closedIslandCount = 0;

    for (let r = 1; r < rows - 1; r++) {
        for (let c = 1; c < cols - 1; c++) {
            if (grid[r][c] === 0) {
                if (dfs(r, c)) {
                    closedIslandCount++;
                }
            }
        }
    }

    return closedIslandCount;
};