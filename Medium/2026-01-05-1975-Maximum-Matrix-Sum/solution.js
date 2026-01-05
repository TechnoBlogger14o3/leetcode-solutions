var maxMatrixSum = function(matrix) {
    let totalSum = 0;
    let minAbsValue = Infinity;
    let negativeCount = 0;

    for (let row of matrix) {
        for (let num of row) {
            if (num < 0) {
                negativeCount++;
            }
            totalSum += Math.abs(num);
            minAbsValue = Math.min(minAbsValue, Math.abs(num));
        }
    }

    if (negativeCount % 2 === 0) {
        return totalSum;
    } else {
        return totalSum - 2 * minAbsValue;
    }
};