var avoidFlood = function(rains) {
    const n = rains.length;
    const ans = new Array(n).fill(-1);
    const fullLakes = new Set();
    const dryDays = [];
    
    for (let i = 0; i < n; i++) {
        if (rains[i] > 0) {
            if (fullLakes.has(rains[i])) {
                return [];
            }
            fullLakes.add(rains[i]);
        } else {
            dryDays.push(i);
        }
    }
    
    for (let i = 0; i < n; i++) {
        if (rains[i] > 0) {
            ans[i] = -1;
            const lake = rains[i];
            fullLakes.delete(lake);
        } else {
            if (fullLakes.size > 0) {
                const lakeToDry = fullLakes.values().next().value;
                ans[i] = lakeToDry;
                fullLakes.delete(lakeToDry);
            } else if (dryDays.length > 0) {
                ans[i] = 1; // Dry any lake (1 is arbitrary)
            }
        }
    }
    
    return ans;
};