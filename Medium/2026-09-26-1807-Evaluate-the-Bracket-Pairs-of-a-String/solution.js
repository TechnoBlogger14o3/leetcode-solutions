var evaluate = function(s, knowledge) {
    const map = new Map(knowledge);
    let result = '';
    let i = 0;

    while (i < s.length) {
        if (s[i] === '(') {
            let j = i + 1;
            while (s[j] !== ')') j++;
            const key = s.slice(i + 1, j);
            result += map.get(key) || '?';
            i = j + 1;
        } else {
            result += s[i];
            i++;
        }
    }

    return result;
};