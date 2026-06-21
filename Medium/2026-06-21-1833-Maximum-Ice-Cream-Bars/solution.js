var maxIceCream = function(costs, coins) {
    const maxCost = Math.max(...costs);
    const count = new Array(maxCost + 1).fill(0);
    
    for (const cost of costs) {
        count[cost]++;
    }
    
    let totalBars = 0;
    
    for (let price = 1; price <= maxCost; price++) {
        while (count[price] > 0 && coins >= price) {
            coins -= price;
            totalBars++;
            count[price]--;
        }
    }
    
    return totalBars;
};