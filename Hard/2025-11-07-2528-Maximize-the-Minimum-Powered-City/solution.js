var maximizeMinPower = function(stations, r, k) {
    const n = stations.length;
    
    const canAchieve = (minPower) => {
        let additionalStations = 0;
        const power = new Array(n).fill(0);
        const addPower = new Array(n + 1).fill(0);
        
        for (let i = 0; i < n; i++) {
            if (i > 0) {
                power[i] += power[i - 1];
            }
            power[i] += addPower[i];
            if (power[i] + stations[i] < minPower) {
                const need = minPower - (power[i] + stations[i]);
                additionalStations += need;
                if (additionalStations > k) return false;
                power[i] += need;
                if (i + 2 * r + 1 < n) {
                    addPower[i + 2 * r + 1] -= need;
                }
            }
        }
        return additionalStations <= k;
    };

    let left = 0, right = 1e10, answer = 0;
    
    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        if (canAchieve(mid)) {
            answer = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return answer;
};