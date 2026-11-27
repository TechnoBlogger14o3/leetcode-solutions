function maxItems(items, budget) {
    const n = items.length;
    const dp = new Array(budget + 1).fill(0);
    
    for (const [factor, price] of items) {
        for (let j = budget; j >= price; j--) {
            dp[j] = Math.max(dp[j], dp[j - price] + 1);
        }
    }

    const freeCount = new Array(n).fill(0);
    for (let i = 0; i < n; i++) {
        const [factorI] = items[i];
        for (let j = 0; j < n; j++) {
            if (i !== j && factorI % items[j][0] === 0) {
                freeCount[i]++;
            }
        }
    }

    let maxTotal = 0;
    for (let j = 0; j <= budget; j++) {
        let totalItems = dp[j];
        for (let i = 0; i < n; i++) {
            if (dp[j] > 0) {
                totalItems += freeCount[i];
            }
        }
        maxTotal = Math.max(maxTotal, totalItems);
    }

    return maxTotal;
}