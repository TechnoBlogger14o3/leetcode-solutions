var minOperations = function(nums, x) {
    const total = nums.reduce((acc, num) => acc + num, 0);
    const target = total - x;
    
    if (target < 0) return -1;

    let maxLength = -1;
    let currentSum = 0;
    const map = new Map();
    map.set(0, -1);

    for (let i = 0; i < nums.length; i++) {
        currentSum += nums[i];
        
        if (map.has(currentSum - target)) {
            maxLength = Math.max(maxLength, i - map.get(currentSum - target));
        }
        
        map.set(currentSum, i);
    }

    return maxLength === -1 ? -1 : nums.length - maxLength;
};