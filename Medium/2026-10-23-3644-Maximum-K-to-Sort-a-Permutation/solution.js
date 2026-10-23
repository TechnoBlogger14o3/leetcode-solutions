var maximumK = function(nums) {
    const n = nums.length;
    const sorted = [...nums].sort((a, b) => a - b);
    
    if (JSON.stringify(nums) === JSON.stringify(sorted)) {
        return 0;
    }

    let maxK = 0;

    for (let k = 0; k < n; k++) {
        const canSort = new Array(n).fill(false);
        for (let i = 0; i < n; i++) {
            if ((nums[i] & k) === k) {
                canSort[nums[i]] = true;
            }
        }
        
        let isSorted = true;
        for (let i = 0; i < n; i++) {
            if (!canSort[sorted[i]]) {
                isSorted = false;
                break;
            }
        }
        
        if (isSorted) {
            maxK = k;
        }
    }

    return maxK;
};