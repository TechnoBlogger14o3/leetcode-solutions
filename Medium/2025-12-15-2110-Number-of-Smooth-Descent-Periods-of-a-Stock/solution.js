var getDescentPeriods = function(prices) {
    let count = 0;
    let currentPeriod = 1;

    for (let i = 1; i < prices.length; i++) {
        if (prices[i] === prices[i - 1] - 1) {
            currentPeriod++;
        } else {
            currentPeriod = 1;
        }
        count += currentPeriod;
    }

    return count + prices.length; // Add the individual days
};