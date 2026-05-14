var isGoodArray = function(nums) {
    const n = Math.max(...nums);
    const count = new Array(n + 1).fill(0);
    
    for (const num of nums) {
        count[num]++;
    }
    
    if (count[n] !== 2) return false;
    
    for (let i = 1; i < n; i++) {
        if (count[i] !== 1) return false;
    }
    
    return true;
};