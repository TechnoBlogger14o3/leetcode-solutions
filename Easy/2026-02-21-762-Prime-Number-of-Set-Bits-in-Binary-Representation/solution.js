var countPrimeSetBits = function(left, right) {
    const isPrime = (num) => {
        if (num < 2) return false;
        for (let i = 2; i * i <= num; i++) {
            if (num % i === 0) return false;
        }
        return true;
    };

    const primeSetBitsCount = new Set([2, 3, 5, 7, 11, 13, 17, 19]); // Prime numbers <= 20

    let count = 0;
    for (let i = left; i <= right; i++) {
        const setBits = i.toString(2).split('0').join('').length;
        if (primeSetBitsCount.has(setBits)) {
            count++;
        }
    }
    return count;
};