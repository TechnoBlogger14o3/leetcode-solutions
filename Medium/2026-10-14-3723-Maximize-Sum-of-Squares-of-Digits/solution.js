var maximumSumOfDigits = function(num, sum) {
    if (sum > 9 * num || sum < 1) return "";
    
    let digits = new Array(num).fill(0);
    
    for (let i = 0; i < num; i++) {
        if (sum > 9) {
            digits[i] = 9;
            sum -= 9;
        } else {
            digits[i] = sum;
            sum = 0;
        }
    }
    
    return digits.join('');
};