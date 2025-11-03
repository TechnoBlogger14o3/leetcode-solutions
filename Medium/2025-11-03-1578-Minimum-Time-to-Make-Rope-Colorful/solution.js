var minCost = function(colors, neededTime) {
    let totalCost = 0;
    let maxTime = 0;
    
    for (let i = 0; i < colors.length; i++) {
        if (i > 0 && colors[i] === colors[i - 1]) {
            totalCost += Math.min(maxTime, neededTime[i]);
            maxTime = Math.max(maxTime, neededTime[i]);
        } else {
            maxTime = neededTime[i];
        }
    }
    
    return totalCost;
};