var circularArrayLoop = function(nums) {
    const n = nums.length;
    const result = new Array(n);
    
    for (let i = 0; i < n; i++) {
        if (nums[i] > 0) {
            result[i] = nums[(i + nums[i]) % n];
        } else if (nums[i] < 0) {
            result[i] = nums[(i + nums[i] + n) % n];
        } else {
            result[i] = 0;
        }
    }
    
    return result;
};