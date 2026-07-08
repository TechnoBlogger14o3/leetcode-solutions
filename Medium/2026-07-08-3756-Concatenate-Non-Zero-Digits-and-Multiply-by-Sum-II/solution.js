var concatenatedSum = function(s, queries) {
    const MOD = 1e9 + 7;
    const results = [];

    for (const [l, r] of queries) {
        let x = '';
        let sum = 0;

        for (let i = l; i <= r; i++) {
            if (s[i] !== '0') {
                x += s[i];
                sum += Number(s[i]);
            }
        }

        const xValue = x === '' ? 0 : BigInt(x);
        const result = (xValue * BigInt(sum)) % BigInt(MOD);
        results.push(Number(result));
    }

    return results;
};