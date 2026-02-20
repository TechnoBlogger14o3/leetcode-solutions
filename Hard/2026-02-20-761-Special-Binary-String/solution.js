var makeLargestSpecial = function(s) {
    let count = 0, start = 0;
    const specialStrings = [];
    
    for (let i = 0; i < s.length; i++) {
        count += s[i] === '1' ? 1 : -1;
        if (count === 0) {
            specialStrings.push('1' + makeLargestSpecial(s.slice(start + 1, i)) + '0');
            start = i + 1;
        }
    }
    
    specialStrings.sort().reverse();
    return specialStrings.join('');
};