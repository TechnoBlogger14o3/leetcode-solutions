function smallestBeautifulString(s, k) {
    let n = s.length;
    let result = "";
    let minLength = Infinity;

    for (let i = 0; i < n; i++) {
        let count = 0;
        for (let j = i; j < n; j++) {
            if (s[j] === '1') count++;
            if (count > k) break;
            if (count === k) {
                let substring = s.slice(i, j + 1);
                if (substring.length < minLength) {
                    minLength = substring.length;
                    result = substring;
                } else if (substring.length === minLength) {
                    result = result < substring ? result : substring;
                }
            }
        }
    }

    return result;
}