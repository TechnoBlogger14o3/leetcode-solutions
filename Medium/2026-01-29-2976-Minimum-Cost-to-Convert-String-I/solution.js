function minimumCost(source, target, original, changed, cost) {
    const n = source.length;
    const costMap = new Map();

    for (let i = 0; i < original.length; i++) {
        const key = original[i] + '->' + changed[i];
        if (!costMap.has(key)) {
            costMap.set(key, cost[i]);
        } else {
            costMap.set(key, Math.min(costMap.get(key), cost[i]));
        }
    }

    let totalCost = 0;

    for (let i = 0; i < n; i++) {
        if (source[i] === target[i]) continue;

        const key = source[i] + '->' + target[i];
        if (!costMap.has(key)) {
            return -1;
        }

        totalCost += costMap.get(key);
    }

    return totalCost;
}