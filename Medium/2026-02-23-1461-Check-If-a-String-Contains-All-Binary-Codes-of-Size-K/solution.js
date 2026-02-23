var hasAllCodes = function(s, k) {
    const totalCodes = 1 << k; // 2^k
    const seen = new Set();

    for (let i = 0; i <= s.length - k; i++) {
        seen.add(s.substring(i, i + k));
        if (seen.size === totalCodes) {
            return true;
        }
    }

    return false;
};