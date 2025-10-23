var digitsAverage = function(s) {
    while (s.length > 2) {
        let newDigits = '';
        for (let i = 0; i < s.length - 1; i++) {
            newDigits += (parseInt(s[i]) + parseInt(s[i + 1])) % 10;
        }
        s = newDigits;
    }
    return s[0] === s[1];
};