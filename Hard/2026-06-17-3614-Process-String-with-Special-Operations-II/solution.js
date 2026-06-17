var processString = function(s, k) {
    let result = [];
    let length = 0;

    for (let char of s) {
        if (char >= 'a' && char <= 'z') {
            result.push(char);
            length++;
        } else if (char === '*') {
            if (length > 0) {
                result.pop();
                length--;
            }
        } else if (char === '#') {
            if (length > 0) {
                let current = result.join('');
                result.push(...current.split(''));
                length *= 2;
            }
        } else if (char === '%') {
            result.reverse();
        }
    }

    return k < length ? result[k] : '.';
};