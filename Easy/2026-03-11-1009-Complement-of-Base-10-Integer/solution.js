var findComplement = function(n) {
    let mask = 1;
    while (mask <= n) {
        mask <<= 1;
    }
    return (mask - 1) ^ n;
};