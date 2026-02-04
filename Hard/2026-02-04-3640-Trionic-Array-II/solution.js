var maximumSum = function(nums) {
    const n = nums.length;
    let maxSum = -Infinity;

    for (let r = 3; r < n; r++) {
        let sum = nums[r];
        let l = r - 1;
        
        // Find p
        while (l > 0 && nums[l - 1] < nums[l]) {
            sum += nums[l - 1];
            l--;
        }
        
        let p = l;
        l = r - 1;

        // Find q
        while (l > 0 && nums[l - 1] > nums[l]) {
            sum += nums[l - 1];
            l--;
        }
        
        let q = l;

        // Find r
        l = r + 1;
        while (l < n && nums[l] > nums[q]) {
            sum += nums[l];
            l++;
        }

        maxSum = Math.max(maxSum, sum);
    }

    return maxSum;
};