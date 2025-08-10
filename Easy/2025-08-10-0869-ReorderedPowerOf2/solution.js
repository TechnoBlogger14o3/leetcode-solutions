/**
 * @param {number} n
 * @return {boolean}
 */
var reorderedPowerOf2 = function(n) {
    const count = countDigits(n);
    
    for (let i = 0; i < 10; i++) {
        if (arraysEqual(count, countDigits(1 << i))) {
            return true;
        }
    }
    return false;
};

function countDigits(n) {
    const count = new Array(10).fill(0);
    while (n > 0) {
        count[n % 10]++;
        n = Math.floor(n / 10);
    }
    return count;
}

function arraysEqual(a, b) {
    return a.length === b.length && a.every((val, index) => val === b[index]);
}
