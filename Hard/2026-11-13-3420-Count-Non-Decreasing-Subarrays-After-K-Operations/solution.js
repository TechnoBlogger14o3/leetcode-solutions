var countNonDecreasingSubarrays = function(nums, k) {
    let n = nums.length;
    let count = 0;
    let left = 0;
    let totalOperations = 0;

    for (let right = 0; right < n; right++) {
        if (right > 0 && nums[right] < nums[right - 1]) {
            totalOperations += (nums[right - 1] - nums[right]);
        }

        while (totalOperations > k) {
            if (left < right && nums[left] < nums[left + 1]) {
                totalOperations -= (nums[left + 1] - nums[left]);
            }
            left++;
        }

        count += (right - left + 1);
    }

    return count;
};