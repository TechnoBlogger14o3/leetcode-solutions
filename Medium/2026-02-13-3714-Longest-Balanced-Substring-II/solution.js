var longestBalancedSubstring = function(s) {
    const n = s.length;
    let maxLength = 0;

    for (let len = 1; len <= n; len++) {
        const count = {};
        for (let i = 0; i < len; i++) {
            count[s[i]] = (count[s[i]] || 0) + 1;
        }
        if (isBalanced(count)) {
            maxLength = len;
        }

        for (let i = len; i < n; i++) {
            count[s[i]] = (count[s[i]] || 0) + 1;
            count[s[i - len]]--;
            if (count[s[i - len]] === 0) {
                delete count[s[i - len]];
            }
            if (isBalanced(count)) {
                maxLength = len;
            }
        }
    }

    return maxLength;
};

function isBalanced(count) {
    const values = Object.values(count);
    const firstValue = values[0];
    return values.every(v => v === firstValue);
}