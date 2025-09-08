var getNoZeroIntegers = function(n) {
    for (let a = 1; a < n; a++) {
        let b = n - a;
        if (!containsZero(a) && !containsZero(b)) {
            return [a, b];
        }
    }
};

function containsZero(num) {
    return num.toString().includes('0');
}