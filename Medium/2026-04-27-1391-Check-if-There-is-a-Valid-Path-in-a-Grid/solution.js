var hasValidPath = function(grid) {
    const m = grid.length, n = grid[0].length;
    const directions = {
        1: [[0, 1], [0, -1]],
        2: [[1, 0], [-1, 0]],
        3: [[0, -1], [1, 0]],
        4: [[0, 1], [1, 0]],
        5: [[0, -1], [-1, 0]],
        6: [[0, 1], [-1, 0]]
    };
    
    const canConnect = {
        1: [1, 1],
        2: [1, 1],
        3: [1, 0],
        4: [0, 1],
        5: [0, 1],
        6: [1, 0]
    };
    
    const visited = Array.from({ length: m }, () => Array(n).fill(false));
    const queue = [[0, 0]];
    visited[0][0] = true;

    while (queue.length) {
        const [x, y] = queue.shift();
        if (x === m - 1 && y === n - 1) return true;

        const currentStreet = grid[x][y];
        for (const [dx, dy] of directions[currentStreet]) {
            const nx = x + dx;
            const ny = y + dy;
            if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) continue;

            const nextStreet = grid[nx][ny];
            if (canConnect[nextStreet][(dx === 0 ? 1 : 0)] && canConnect[nextStreet][(dy === 0 ? 1 : 0)]) {
                visited[nx][ny] = true;
                queue.push([nx, ny]);
            }
        }
    }
    
    return false;
};