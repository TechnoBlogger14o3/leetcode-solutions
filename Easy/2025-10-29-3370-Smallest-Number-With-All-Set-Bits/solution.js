var smallestGoodBase = function(n) {
    let maxPower = Math.floor(Math.log(n) / Math.log(2));
    for (let k = maxPower; k >= 1; k--) {
        let base = Math.floor(Math.pow(n, 1 / k));
        let sum = (base ** (k + 1) - 1) / (base - 1);
        if (sum === n) {
            return base.toString(2).repeat(k + 1);
        }
    }
    return (n).toString(2).repeat(1);
};