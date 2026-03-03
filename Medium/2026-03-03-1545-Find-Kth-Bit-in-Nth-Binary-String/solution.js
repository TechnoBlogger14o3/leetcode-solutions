var findKthBit = function(n, k) {
    const getLength = (n) => (1 << n) - 1; // 2^n - 1

    const getKthBit = (n, k) => {
        if (n === 1) return '0';
        const len = getLength(n);
        const mid = len / 2 + 1;

        if (k === mid) return '1';
        if (k < mid) return getKthBit(n - 1, k);
        return getKthBit(n - 1, len - k + 1) === '0' ? '1' : '0';
    };

    return getKthBit(n, k);
};