var sumGame = function(num) {
    const n = num.length;
    let leftSum = 0, rightSum = 0, leftQuestionMarks = 0, rightQuestionMarks = 0;

    for (let i = 0; i < n / 2; i++) {
        if (num[i] === '?') {
            leftQuestionMarks++;
        } else {
            leftSum += Number(num[i]);
        }
    }

    for (let i = n / 2; i < n; i++) {
        if (num[i] === '?') {
            rightQuestionMarks++;
        } else {
            rightSum += Number(num[i]);
        }
    }

    const totalQuestionMarks = leftQuestionMarks + rightQuestionMarks;
    const diff = leftSum - rightSum;

    if (diff === 0) {
        return totalQuestionMarks % 2 === 1;
    }

    const maxDiff = Math.abs(diff) + 9 * Math.abs(leftQuestionMarks - rightQuestionMarks);
    return maxDiff > 0;
};