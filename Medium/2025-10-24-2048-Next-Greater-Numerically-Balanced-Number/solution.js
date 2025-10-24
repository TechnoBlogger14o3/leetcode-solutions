function nextGreaterBalancedNumber(n) {
    const isBalanced = (num) => {
        const count = {};
        const strNum = num.toString();
        for (const char of strNum) {
            count[char] = (count[char] || 0) + 1;
        }
        for (const [digit, occurrences] of Object.entries(count)) {
            if (parseInt(digit) !== occurrences) {
                return false;
            }
        }
        return true;
    };

    let nextNum = n + 1;
    while (true) {
        if (isBalanced(nextNum)) {
            return nextNum;
        }
        nextNum++;
    }
}