var processString = function(s) {
    let result = '';
    
    for (let char of s) {
        if (char >= 'a' && char <= 'z') {
            result += char;
        } else if (char === '*') {
            result = result.slice(0, -1);
        } else if (char === '#') {
            result += result;
        } else if (char === '%') {
            result = result.split('').reverse().join('');
        }
    }
    
    return result;
};