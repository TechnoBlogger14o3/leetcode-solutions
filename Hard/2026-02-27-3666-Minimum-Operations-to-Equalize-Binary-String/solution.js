var minOperations = function(s, k) {
    const countZeros = (s.match(/0/g) || []).length;
    if (countZeros === 0) return 0;
    if (countZeros < k) return -1;

    let operations = 0;
    while (countZeros > 0) {
        operations++;
        countZeros -= k;
        if (countZeros < 0) return -1;
    }
    return operations;
};