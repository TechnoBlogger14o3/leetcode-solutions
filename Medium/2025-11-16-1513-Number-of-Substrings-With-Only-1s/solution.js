var numSub = function(s) {
    const MOD = 1e9 + 7;
    let count = 0, result = 0;

    for (let char of s) {
        if (char === '1') {
            count++;
            result = (result + count) % MOD;
        } else {
            count = 0;
        }
    }

    return result;
};