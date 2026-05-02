var rotatedDigits = function(n) {
    const goodDigits = new Set(['2', '5', '6', '9']);
    const validDigits = new Set(['0', '1', '8', '2', '5', '6', '9']);
    
    let count = 0;

    for (let i = 1; i <= n; i++) {
        const strNum = i.toString();
        let isGood = false;
        let isValid = true;

        for (const char of strNum) {
            if (!validDigits.has(char)) {
                isValid = false;
                break;
            }
            if (goodDigits.has(char)) {
                isGood = true;
            }
        }

        if (isValid && isGood) {
            count++;
        }
    }

    return count;
};