var countTrapezoids = function(points) {
    const MOD = 1e9 + 7;
    const yMap = new Map();

    for (const [x, y] of points) {
        if (!yMap.has(y)) {
            yMap.set(y, []);
        }
        yMap.get(y).push(x);
    }

    let count = 0;

    for (const [y1, xList1] of yMap) {
        for (const [y2, xList2] of yMap) {
            if (y1 >= y2) continue;
            const commonX = xList1.filter(x => xList2.includes(x));
            const len1 = xList1.length;
            const len2 = xList2.length;
            const commonLen = commonX.length;

            if (commonLen >= 2) {
                count = (count + (len1 - commonLen) * (len2 - commonLen) * (commonLen * (commonLen - 1) / 2)) % MOD) % MOD;
            }
        }
    }

    return count;
};