var totalWaviness = function(num1, num2) {
    let totalWaviness = 0;

    for (let i = num1; i <= num2; i++) {
        const strNum = i.toString();
        const len = strNum.length;

        if (len < 3) continue;

        let waviness = 0;

        for (let j = 1; j < len - 1; j++) {
            if (strNum[j] > strNum[j - 1] && strNum[j] > strNum[j + 1]) {
                waviness++;
            } else if (strNum[j] < strNum[j - 1] && strNum[j] < strNum[j + 1]) {
                waviness++;
            }
        }

        totalWaviness += waviness;
    }

    return totalWaviness;
};