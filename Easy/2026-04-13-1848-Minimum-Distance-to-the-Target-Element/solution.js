var getMinDistance = function(nums, target, start) {
    let minDistance = Infinity;
    
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === target) {
            minDistance = Math.min(minDistance, Math.abs(i - start));
        }
    }
    
    return minDistance;
};