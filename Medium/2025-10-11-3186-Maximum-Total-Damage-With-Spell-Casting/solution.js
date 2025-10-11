var maximumDamage = function(power) {
    const count = new Map();
    for (const p of power) {
        count.set(p, (count.get(p) || 0) + 1);
    }

    const dp = new Map();
    const uniquePowers = Array.from(count.keys()).sort((a, b) => a - b);

    for (const p of uniquePowers) {
        const damage = p * count.get(p);
        dp.set(p, damage + (dp.get(p - 3) || 0));
        if (p > 1) {
            dp.set(p, Math.max(dp.get(p), (dp.get(p - 2) || 0) + damage));
        }
    }

    return Math.max(...dp.values());
};