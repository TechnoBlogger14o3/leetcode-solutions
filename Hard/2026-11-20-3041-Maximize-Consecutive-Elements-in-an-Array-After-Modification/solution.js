var maxConsecutive = function(nums) {
    const n = nums.length;
    nums.sort((a, b) => a - b);
    
    let maxCount = 0;
    let left = 0;
    
    for (let right = 0; right < n; right++) {
        while (nums[right] - nums[left] > 1) {
            left++;
        }
        maxCount = Math.max(maxCount, right - left + 1);
    }
    
    return maxCount;
};