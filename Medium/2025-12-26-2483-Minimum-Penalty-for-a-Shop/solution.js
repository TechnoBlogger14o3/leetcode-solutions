var bestClosingTime = function(customers) {
    let penalty = 0;
    let minPenalty = Infinity;
    let bestHour = 0;

    for (let i = 0; i < customers.length; i++) {
        if (customers[i] === 'N') {
            penalty++;
        }
    }

    for (let j = 0; j <= customers.length; j++) {
        if (penalty < minPenalty) {
            minPenalty = penalty;
            bestHour = j;
        }
        if (j < customers.length) {
            if (customers[j] === 'Y') {
                penalty++;
            } else {
                penalty--;
            }
        }
    }

    return bestHour;
};