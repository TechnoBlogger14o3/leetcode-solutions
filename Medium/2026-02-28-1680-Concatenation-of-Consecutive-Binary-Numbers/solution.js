var concatenatedBinary = function(n) {
    const MOD = 1e9 + 7;
    let result = 0;
    let length = 0;

    for (let i = 1; i <= n; i++) {
        if ((i & (i - 1)) === 0) {
            length++;
        }
        result = ((result << length) | i) % MOD;
    }

    return result;
};