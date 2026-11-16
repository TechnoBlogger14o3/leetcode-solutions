var digitSum = function(s, k) {
    while (s.length > k) {
        let newS = '';
        for (let i = 0; i < s.length; i += k) {
            const group = s.slice(i, i + k);
            const sum = group.split('').reduce((acc, digit) => acc + Number(digit), 0);
            newS += sum.toString();
        }
        s = newS;
    }
    return s;
};