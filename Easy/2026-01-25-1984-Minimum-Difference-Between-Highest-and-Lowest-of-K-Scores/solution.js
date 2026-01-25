var minimumDifference = function(nums, k) {
    nums.sort((a, b) => a - b);
    let minDiff = Infinity;

    for (let i = 0; i <= nums.length - k; i++) {
        const diff = nums[i + k - 1] - nums[i];
        minDiff = Math.min(minDiff, diff);
    }

    return minDiff;
};