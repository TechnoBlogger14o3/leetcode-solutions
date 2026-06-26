var countSubarrays = function(nums, target) {
    let count = 0;
    let total = 0;
    let n = nums.length;
    
    for (let i = 0; i < n; i++) {
        if (nums[i] === target) {
            total++;
        } else {
            total--;
        }
        
        if (total > 0) {
            count += i + 1;
        } else {
            let j = i;
            while (j >= 0 && total <= 0) {
                if (nums[j] === target) {
                    total++;
                } else {
                    total--;
                }
                j--;
            }
            count += i - j;
        }
    }
    
    return count;
};