var pathsWithMaxScore = function(board) {
    const MOD = 1e9 + 7;
    const n = board.length;
    const dp = Array.from({ length: n }, () => Array(n).fill([0, 0]));
    
    dp[n-1][n-1] = [0, 1]; // Starting point S

    for (let i = n - 1; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            if (board[i][j] === 'X' || (i === n - 1 && j === n - 1)) continue;

            const score = board[i][j] === 'E' ? 0 : parseInt(board[i][j]);
            const directions = [[1, 0], [0, 1], [1, 1]]; // down, right, down-right

            for (const [di, dj] of directions) {
                const ni = i + di, nj = j + dj;
                if (ni < n && nj < n && board[ni][nj] !== 'X') {
                    const [nextScore, nextCount] = dp[ni][nj];
                    if (nextScore + score > dp[i][j][0]) {
                        dp[i][j] = [nextScore + score, nextCount];
                    } else if (nextScore + score === dp[i][j][0]) {
                        dp[i][j][1] = (dp[i][j][1] + nextCount) % MOD;
                    }
                }
            }
            if (score > 0) {
                dp[i][j][0] += score;
            }
        }
    }

    const result = dp[0][0];
    return result[0] === 0 && result[1] === 0 ? [0, 0] : [result[0], result[1]];
};