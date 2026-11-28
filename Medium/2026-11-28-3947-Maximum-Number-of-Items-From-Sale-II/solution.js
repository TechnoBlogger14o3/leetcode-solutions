var maxItems = function(items, budget) {
    const n = items.length;
    items.sort((a, b) => a[1] - b[1]);
    
    let totalPurchased = 0;
    let totalFree = 0;
    const freeItems = new Array(n).fill(0);
    
    for (let i = 0; i < n; i++) {
        const [factor, price] = items[i];
        if (price > budget) continue;
        
        const maxBuy = Math.floor(budget / price);
        totalPurchased += maxBuy;
        budget -= maxBuy * price;
        
        for (let j = 0; j < n; j++) {
            if (i !== j && factor % items[j][0] === 0) {
                freeItems[j] = 1; // Mark that we can get a free copy of item j
            }
        }
    }
    
    totalFree = freeItems.reduce((sum, val) => sum + val, 0);
    
    return totalPurchased + totalFree;
};