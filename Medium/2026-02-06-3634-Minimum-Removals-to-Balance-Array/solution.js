var minimumRemovals = function(nums, k) {
    nums.sort((a, b) => a - b);
    let left = 0, result = nums.length;

    for (let right = 0; right < nums.length; right++) {
        while (nums[right] > nums[left] * k) {
            left++;
        }
        result = Math.min(result, right - left + 1);
    }

    return nums.length - result;
};