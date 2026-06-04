var totalWaviness = function(num1, num2) {
    let totalWaviness = 0;

    for (let num = num1; num <= num2; num++) {
        const digits = num.toString().split('').map(Number);
        let waviness = 0;

        for (let i = 1; i < digits.length - 1; i++) {
            if ((digits[i] > digits[i - 1] && digits[i] > digits[i + 1]) || 
                (digits[i] < digits[i - 1] && digits[i] < digits[i + 1])) {
                waviness++;
            }
        }

        totalWaviness += waviness;
    }

    return totalWaviness;
};