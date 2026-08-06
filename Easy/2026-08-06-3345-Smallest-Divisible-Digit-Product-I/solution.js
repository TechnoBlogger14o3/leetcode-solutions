var smallestDivisibleDigitProduct = function(n, t) {
    while (true) {
        let product = 1;
        let num = n.toString();
        for (let char of num) {
            product *= parseInt(char);
        }
        if (product % t === 0) {
            return n;
        }
        n++;
    }
};