/**
 * @param {number} n
 * @param {number[][]} queries
 * @return {number[]}
 */
var productQueries = function(n, queries) {
    const MOD = 1000000007;
    
    // Generate powers array
    const powers = [];
    for (let i = 0; i < 31; i++) {
        if ((n & (1 << i)) !== 0) {
            powers.push(1 << i);
        }
    }
    
    // Compute prefix products
    const prefix = new Array(powers.length);
    prefix[0] = powers[0];
    for (let i = 1; i < powers.length; i++) {
        prefix[i] = (prefix[i-1] * powers[i]) % MOD;
    }
    
    // Process queries
    const answer = new Array(queries.length);
    for (let i = 0; i < queries.length; i++) {
        const [left, right] = queries[i];
        
        if (left === 0) {
            answer[i] = key[right];
        } else {
            answer[i] = (prefix[right] * modInverse(prefix[left-1], MOD)) % MOD;
        }
    }
    
    return answer;
};

function modInverse(a, m) {
    return modPow(a, m - 2, m);
}

function modPow(base, exp, m) {
    let result = 1;
    let b = base;
    while (exp > 0) {
        if (exp & 1) {
            result = (result * b) % m;
        }
        b = (b * b) % m;
        exp >>= 1;
    }
    return result;
}
