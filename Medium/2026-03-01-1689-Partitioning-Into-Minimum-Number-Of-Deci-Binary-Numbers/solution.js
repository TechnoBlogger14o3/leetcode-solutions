var minPartitions = function(n) {
    let maxDigit = 0;
    for (let char of n) {
        maxDigit = Math.max(maxDigit, Number(char));
    }
    return maxDigit;
};