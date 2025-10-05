var pacificAtlantic = function(heights) {
    if (!heights.length || !heights[0].length) return [];

    const m = heights.length, n = heights[0].length;
    const pacific = Array.from({ length: m }, () => Array(n).fill(false));
    const atlantic = Array.from({ length: m }, () => Array(n).fill(false));
    const directions = [[0, 1], [1, 0], [0, -1], [-1, 0]];

    const dfs = (r, c, visited, prevHeight) => {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }
        visited[r][c] = true;
        for (const [dr, dc] of directions) {
            dfs(r + dr, c + dc, visited, heights[r][c]);
        }
    };

    for (let i = 0; i < m; i++) {
        dfs(i, 0, pacific, heights[i][0]); // Pacific left edge
        dfs(i, n - 1, atlantic, heights[i][n - 1]); // Atlantic right edge
    }
    for (let j = 0; j < n; j++) {
        dfs(0, j, pacific, heights[0][j]); // Pacific top edge
        dfs(m - 1, j, atlantic, heights[m - 1][j]); // Atlantic bottom edge
    }

    const result = [];
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (pacific[i][j] && atlantic[i][j]) {
                result.push([i, j]);
            }
        }
    }
    return result;
};