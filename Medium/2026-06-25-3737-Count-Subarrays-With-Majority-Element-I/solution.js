var countSubarrays = function(nums, target) {
    let count = 0;
    let n = nums.length;
    
    for (let i = 0; i < n; i++) {
        if (nums[i] === target) {
            let majorityCount = 0;
            for (let j = i; j < n; j++) {
                if (nums[j] === target) majorityCount++;
                if (majorityCount > (j - i + 1) / 2) {
                    count++;
                }
            }
        }
    }
    
    return count;
};