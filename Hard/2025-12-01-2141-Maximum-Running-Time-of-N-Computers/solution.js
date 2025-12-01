var maxRunTime = function(n, batteries) {
    let left = 0, right = Math.floor(batteries.reduce((a, b) => a + b, 0) / n);
    
    while (left < right) {
        const mid = Math.floor((left + right + 1) / 2);
        let total = 0;
        
        for (const battery of batteries) {
            total += Math.min(battery, mid);
        }
        
        if (total >= mid * n) {
            left = mid;
        } else {
            right = mid - 1;
        }
    }
    
    return left;
};