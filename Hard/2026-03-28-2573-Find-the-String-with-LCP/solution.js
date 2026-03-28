function findTheString(lcp) {
    const n = lcp.length;
    const word = new Array(n).fill('a');

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (lcp[i][j] > 0) {
                if (i + lcp[i][j] > n || j + lcp[i][j] > n) return "";
                for (let k = 0; k < lcp[i][j]; k++) {
                    if (word[i + k] === 'a' && word[j + k] === 'b') {
                        word[j + k] = 'c';
                    } else if (word[i + k] === 'b' && word[j + k] === 'a') {
                        word[j + k] = 'c';
                    } else if (word[i + k] === 'c' || word[j + k] === 'c') {
                        return "";
                    }
                }
            }
        }
    }

    return word.join('');
}