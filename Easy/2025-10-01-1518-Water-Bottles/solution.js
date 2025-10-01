var numWaterBottles = function(numBottles, numExchange) {
    let totalDrunk = numBottles;
    let emptyBottles = numBottles;

    while (emptyBottles >= numExchange) {
        let newBottles = Math.floor(emptyBottles / numExchange);
        totalDrunk += newBottles;
        emptyBottles = newBottles + (emptyBottles % numExchange);
    }

    return totalDrunk;
};