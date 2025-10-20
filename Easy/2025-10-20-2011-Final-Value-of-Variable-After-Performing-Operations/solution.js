var finalValueAfterOperations = function(operations) {
    let X = 0;
    for (const op of operations) {
        if (op === '++X' || op === 'X++') {
            X++;
        } else {
            X--;
        }
    }
    return X;
};