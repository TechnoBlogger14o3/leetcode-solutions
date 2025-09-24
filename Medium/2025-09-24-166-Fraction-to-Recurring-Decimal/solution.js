var fractionToDecimal = function(numerator, denominator) {
    if (numerator === 0) return "0";
    
    let result = '';
    if (numerator < 0 ^ denominator < 0) result += '-';
    
    numerator = Math.abs(numerator);
    denominator = Math.abs(denominator);
    
    result += Math.floor(numerator / denominator).toString();
    numerator %= denominator;
    
    if (numerator === 0) return result;
    
    result += '.';
    const map = new Map();
    map.set(numerator, result.length);
    
    while (numerator !== 0) {
        numerator *= 10;
        result += Math.floor(numerator / denominator);
        numerator %= denominator;
        
        if (map.has(numerator)) {
            const index = map.get(numerator);
            result = result.slice(0, index) + '(' + result.slice(index) + ')';
            return result;
        }
        
        map.set(numerator, result.length);
    }
    
    return result;
};