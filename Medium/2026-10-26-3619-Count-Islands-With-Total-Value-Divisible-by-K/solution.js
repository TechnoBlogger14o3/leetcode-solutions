class Solution {
    countIslands(grid, k) {
        const m = grid.length;
        const n = grid[0].length;
        const visited = Array.from({ length: m }, () => Array(n).fill(false));
        let islandCount = 0;

        const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];

        const dfs = (i, j) => {
            let totalValue = 0;
            const stack = [[i, j]];
            visited[i][j] = true;

            while (stack.length) {
                const [x, y] = stack.pop();
                totalValue += grid[x][y];

                for (const [dx, dy] of directions) {
                    const newX = x + dx;
                    const newY = y + dy;

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] > 0 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        stack.push([newX, newY]);
                    }
                }
            }
            return totalValue;
        };

        for (let i = 0; i < m; i++) {
            for (let j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    const totalValue = dfs(i, j);
                    if (totalValue % k === 0) {
                        islandCount++;
                    }
                }
            }
        }

        return islandCount;
    }
}