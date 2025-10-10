var maxEnergy = function(energy, k) {
    const n = energy.length;
    let maxGain = Number.NEGATIVE_INFINITY;

    for (let start = 0; start < k; start++) {
        let currentGain = 0;
        for (let i = start; i < n; i += k) {
            currentGain += energy[i];
        }
        maxGain = Math.max(maxGain, currentGain);
    }

    return maxGain;
};