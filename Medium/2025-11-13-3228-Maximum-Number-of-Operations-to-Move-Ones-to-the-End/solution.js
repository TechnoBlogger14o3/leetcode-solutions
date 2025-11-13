var maximumOperations = function(s) {
    let countOnes = 0;
    let operations = 0;

    for (let char of s) {
        if (char === '1') {
            countOnes++;
        } else if (countOnes > 0) {
            operations++;
        }
    }

    return operations;
};