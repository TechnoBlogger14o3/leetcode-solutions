var swimInWater = function(grid) {
    const n = grid.length;
    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    let left = 0, right = Math.max(...grid.flat());

    const canSwim = (t) => {
        const visited = Array.from({ length: n }, () => Array(n).fill(false));
        const queue = [[0, 0]];
        visited[0][0] = true;

        while (queue.length) {
            const [x, y] = queue.shift();
            if (x === n - 1 && y === n - 1) return true;

            for (const [dx, dy] of directions) {
                const nx = x + dx, ny = y + dy;
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] <= t) {
                    visited[nx][ny] = true;
                    queue.push([nx, ny]);
                }
            }
        }
        return false;
    };

    while (left < right) {
        const mid = Math.floor((left + right) / 2);
        if (canSwim(mid)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    return left;
};