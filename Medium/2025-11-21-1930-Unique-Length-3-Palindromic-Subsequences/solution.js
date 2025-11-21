var countPalindromicSubsequences = function(s) {
    const seen = new Set();
    const n = s.length;

    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            if (s[i] === s[j]) {
                for (let k = 0; k < n; k++) {
                    if (k !== i && k !== j && s[k] === s[i]) {
                        seen.add(s[i] + s[j] + s[i]);
                    }
                }
            }
        }
    }

    return seen.size;
};