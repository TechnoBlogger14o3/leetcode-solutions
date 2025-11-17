var kLengthApart = function(nums, k) {
    let lastIndex = -1;
    
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 1) {
            if (lastIndex !== -1 && i - lastIndex - 1 < k) {
                return false;
            }
            lastIndex = i;
        }
    }
    
    return true;
};