class Solution {
    maxSafenessFactor(grid) {
        const n = grid.length;
        const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];
        
        const bfs = (start) => {
            const dist = Array.from({ length: n }, () => Array(n).fill(Infinity));
            const queue = [start];
            dist[start[0]][start[1]] = 0;

            while (queue.length) {
                const [x, y] = queue.shift();
                for (const [dx, dy] of directions) {
                    const nx = x + dx;
                    const ny = y + dy;
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (dist[nx][ny] > dist[x][y] + 1) {
                            dist[nx][ny] = dist[x][y] + 1;
                            queue.push([nx, ny]);
                        }
                    }
                }
            }
            return dist;
        };

        const thieves = [];
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < n; j++) {
                if (grid[i][j] === 1) {
                    thieves.push([i, j]);
                }
            }
        }

        const minDist = Array.from({ length: n }, () => Array(n).fill(Infinity));
        for (const thief of thieves) {
            const dist = bfs(thief);
            for (let i = 0; i < n; i++) {
                for (let j = 0; j < n; j++) {
                    minDist[i][j] = Math.min(minDist[i][j], dist[i][j]);
                }
            }
        }

        const bfsPath = (start) => {
            const safeness = Array.from({ length: n }, () => Array(n).fill(-1));
            const queue = [start];
            safeness[start[0]][start[1]] = minDist[start[0]][start[1]];

            while (queue.length) {
                const [x, y] = queue.shift();
                for (const [dx, dy] of directions) {
                    const nx = x + dx;
                    const ny = y + dy;
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        const newSafeness = Math.min(safeness[x][y], minDist[nx][ny]);
                        if (newSafeness > safeness[nx][ny]) {
                            safeness[nx][ny] = newSafeness;
                            queue.push([nx, ny]);
                        }
                    }
                }
            }
            return safeness[n - 1][n - 1];
        };

        return bfsPath([0, 0]);
    }
}