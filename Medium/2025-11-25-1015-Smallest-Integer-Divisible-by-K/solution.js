var smallestRepunitDivByK = function(k) {
    if (k % 2 === 0 || k % 5 === 0) return -1;
    
    let n = 1;
    let remainder = 1 % k;
    
    while (remainder !== 0) {
        remainder = (remainder * 10 + 1) % k;
        n++;
    }
    
    return n;
};