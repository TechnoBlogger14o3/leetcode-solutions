var checkDivisibility = function(n) {
    let sum = 0;
    let product = 1;
    let temp = n;

    while (temp > 0) {
        let digit = temp % 10;
        sum += digit;
        product *= digit;
        temp = Math.floor(temp / 10);
    }

    return n % (sum + product) === 0;
};