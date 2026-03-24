var constructProductMatrix = function(grid) {
    const n = grid.length;
    const m = grid[0].length;
    const p = Array.from({ length: n }, () => Array(m).fill(1));
    const mod = 12345;

    const rowProducts = Array(n).fill(1);
    const colProducts = Array(m).fill(1);

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            rowProducts[i] = (rowProducts[i] * grid[i][j]) % mod;
            colProducts[j] = (colProducts[j] * grid[i][j]) % mod;
        }
    }

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            p[i][j] = (rowProducts[i] * colProducts[j] / grid[i][j]) % mod;
        }
    }

    return p;
};