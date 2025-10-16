var findSmallestInteger = function(nums, value) {
    const reachable = new Set();
    
    for (const num of nums) {
        const start = num >= 0 ? num % value : (num % value + value) % value;
        for (let i = start; i <= 1e9; i += value) {
            reachable.add(i);
        }
    }
    
    let mex = 0;
    while (reachable.has(mex)) {
        mex++;
    }
    
    return mex;
};