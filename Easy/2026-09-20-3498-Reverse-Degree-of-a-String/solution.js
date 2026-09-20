var reverseDegree = function(s) {
    let total = 0;
    for (let i = 0; i < s.length; i++) {
        const charValue = 26 - (s[i].charCodeAt(0) - 'a'.charCodeAt(0));
        total += charValue * (i + 1);
    }
    return total;
};