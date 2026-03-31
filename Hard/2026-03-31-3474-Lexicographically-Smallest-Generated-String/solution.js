var smallestString = function(str1, str2) {
    const n = str1.length;
    const m = str2.length;
    const result = new Array(n + m - 1).fill('a');

    for (let i = 0; i < n; i++) {
        if (str1[i] === 'T') {
            if (i + m - 1 >= result.length) return "";
            for (let j = 0; j < m; j++) {
                if (result[i + j] !== 'a' && result[i + j] !== str2[j]) {
                    return "";
                }
                result[i + j] = str2[j];
            }
        }
    }

    for (let i = 0; i < n; i++) {
        if (str1[i] === 'F') {
            if (i + m - 1 >= result.length) return "";
            const temp = result.slice(i, i + m).join('');
            if (temp === str2) return "";
            for (let j = 0; j < m; j++) {
                if (result[i + j] === 'a') {
                    result[i + j] = 'a';
                } else if (result[i + j] === str2[j]) {
                    result[i + j] = 'z';
                }
            }
        }
    }

    return result.join('');
};