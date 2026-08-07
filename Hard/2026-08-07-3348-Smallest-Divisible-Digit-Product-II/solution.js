var smallestDivisibleDigitsProduct = function(num, t) {
    const isZeroFree = (n) => !n.includes('0');
    const productDivisibleByT = (n) => {
        let product = 1;
        for (const digit of n) {
            product *= Number(digit);
        }
        return product % t === 0;
    };

    const increment = (n) => {
        let arr = n.split('');
        let i = arr.length - 1;
        while (i >= 0) {
            if (arr[i] !== '9') {
                arr[i] = String(Number(arr[i]) + 1);
                return arr.join('');
            }
            arr[i] = '0';
            i--;
        }
        return '1' + arr.join('');
    };

    let currentNum = num;
    while (true) {
        if (isZeroFree(currentNum) && productDivisibleByT(currentNum)) {
            return currentNum;
        }
        currentNum = increment(currentNum);
        if (currentNum.length > num.length + 1) {
            break;
        }
    }
    return "-1";
};