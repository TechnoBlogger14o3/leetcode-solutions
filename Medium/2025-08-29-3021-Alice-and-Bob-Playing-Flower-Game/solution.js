javascript
var countPairs = function(n, m) {
    let count = 0;
    for (let x = 1; x <= n; x++) {
        for (let y = 1; y <= m; y++) {
            if ((x + y) % 2 === 1) {
                count++;
            }
        }
    }
    return count;
};