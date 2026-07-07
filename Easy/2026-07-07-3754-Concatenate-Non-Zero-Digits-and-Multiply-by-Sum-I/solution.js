var concatenatedSum = function(n) {
    const digits = n.toString().split('').filter(d => d !== '0');
    if (digits.length === 0) return 0;
    
    const x = parseInt(digits.join(''), 10);
    const sum = digits.reduce((acc, d) => acc + parseInt(d, 10), 0);
    
    return x * sum;
};