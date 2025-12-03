var countTrapezoids = function(points) {
    const slopes = new Map();
    const n = points.length;

    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            const dx = points[j][0] - points[i][0];
            const dy = points[j][1] - points[i][1];
            const gcd = getGCD(dx, dy);
            const slope = `${dy / gcd},${dx / gcd}`;
            if (!slopes.has(slope)) {
                slopes.set(slope, new Set());
            }
            slopes.get(slope).add(`${points[i][0]},${points[i][1]}`);
            slopes.get(slope).add(`${points[j][0]},${points[j][1]}`);
        }
    }

    let count = 0;
    for (const set of slopes.values()) {
        const size = set.size;
        if (size >= 4) {
            count += (size * (size - 1) * (size - 2) * (size - 3)) / 24;
        }
    }

    return count;
};

function getGCD(a, b) {
    while (b) {
        [a, b] = [b, a % b];
    }
    return a;
}