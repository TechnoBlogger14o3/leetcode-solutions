var scoreOfParentheses = function(s) {
    let score = 0;
    let depth = 0;

    for (let char of s) {
        if (char === '(') {
            depth++;
        } else {
            depth--;
            if (s[s.indexOf(char) - 1] === '(') {
                score += 1 << depth; // 2^depth
            }
        }
    }

    return score;
};