function minimumCost(cost1, cost2, costBoth, need1, need2) {
    let minCost = Infinity;

    for (let both = 0; both <= Math.min(need1, need2); both++) {
        const remainingNeed1 = Math.max(0, need1 - both);
        const remainingNeed2 = Math.max(0, need2 - both);
        const cost = both * costBoth + remainingNeed1 * cost1 + remainingNeed2 * cost2;
        minCost = Math.min(minCost, cost);
    }

    return minCost;
}