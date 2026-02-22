var binaryGap = function(n) {
    let lastIndex = -1;
    let maxDistance = 0;
    
    for (let i = 0; n > 0; i++) {
        if (n & 1) {
            if (lastIndex !== -1) {
                maxDistance = Math.max(maxDistance, i - lastIndex);
            }
            lastIndex = i;
        }
        n >>= 1;
    }
    
    return maxDistance;
};