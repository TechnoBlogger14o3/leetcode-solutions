var countTriples = function(n) {
    let count = 0;
    for (let a = 1; a <= n; a++) {
        for (let b = a; b <= n; b++) {
            const c2 = a * a + b * b;
            const c = Math.sqrt(c2);
            if (c % 1 === 0 && c <= n) {
                count += (a === b) ? 1 : 2; // (a, b, c) and (b, a, c) are distinct if a != b
            }
        }
    }
    return count;
};