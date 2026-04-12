var minimumDistance = function(word) {
    const positions = {};
    const alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    
    for (let i = 0; i < alphabet.length; i++) {
        positions[alphabet[i]] = [Math.floor(i / 6), i % 6];
    }
    
    const n = word.length;
    const dp = Array.from({ length: n + 1 }, () => Array(27).fill(Infinity));
    dp[0][26] = 0; // Starting with both fingers free

    for (let i = 0; i < n; i++) {
        const [x1, y1] = positions[word[i]];
        for (let j = 0; j <= 26; j++) {
            if (dp[i][j] === Infinity) continue;
            // Move finger 1 to current letter
            const dist1 = j === 26 ? 0 : Math.abs(x1 - positions[alphabet[j]][0]) + Math.abs(y1 - positions[alphabet[j]][1]);
            dp[i + 1][i] = Math.min(dp[i + 1][i], dp[i][j] + dist1);
            // Move finger 2 to current letter
            const dist2 = j === 26 ? 0 : Math.abs(x1 - positions[alphabet[j]][0]) + Math.abs(y1 - positions[alphabet[j]][1]);
            dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + dist2);
        }
    }

    return Math.min(...dp[n]);
};