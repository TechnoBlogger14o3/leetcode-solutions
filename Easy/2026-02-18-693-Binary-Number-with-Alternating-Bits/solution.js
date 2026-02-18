var hasAlternatingBits = function(n) {
    let lastBit = n & 1;
    n >>= 1;
    
    while (n > 0) {
        let currentBit = n & 1;
        if (currentBit === lastBit) {
            return false;
        }
        lastBit = currentBit;
        n >>= 1;
    }
    
    return true;
};