var makeSmallestPalindrome = function(s) {
    let n = s.length;
    let result = new Array(n);
    
    for (let i = 0; i < Math.floor(n / 2); i++) {
        result[i] = result[n - 1 - i] = String.fromCharCode(Math.min(s.charCodeAt(i), s.charCodeAt(n - 1 - i)));
    }
    
    if (n % 2 === 1) {
        result[Math.floor(n / 2)] = s[Math.floor(n / 2)];
    }
    
    return result.join('');
};