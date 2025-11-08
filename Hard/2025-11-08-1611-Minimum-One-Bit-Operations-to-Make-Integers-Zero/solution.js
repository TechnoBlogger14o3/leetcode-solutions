var minimumOneBitOperations = function(n) {
    let operations = 0;
    while (n > 0) {
        operations ^= n; // XOR with n
        n >>= 1; // Right shift n
    }
    return operations;
};