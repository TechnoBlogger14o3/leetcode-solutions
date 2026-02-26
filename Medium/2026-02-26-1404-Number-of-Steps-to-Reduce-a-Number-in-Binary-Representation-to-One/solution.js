var numSteps = function(s) {
    let steps = 0;
    let carry = 0;

    for (let i = s.length - 1; i > 0; i--) {
        if (s[i] === '0') {
            steps++; // Even case: divide by 2
        } else {
            steps += 2; // Odd case: add 1 and then divide by 2
        }
    }

    return steps + carry;
};