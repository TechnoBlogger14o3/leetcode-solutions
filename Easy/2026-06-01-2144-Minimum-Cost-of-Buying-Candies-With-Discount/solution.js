function minimumCost(cost) {
    cost.sort((a, b) => b - a);
    let totalCost = 0;

    for (let i = 0; i < cost.length; i++) {
        totalCost += cost[i];
        if ((i + 1) % 3 === 0) {
            totalCost -= cost[i]; // Remove the cost of the free candy
        }
    }

    return totalCost;
}