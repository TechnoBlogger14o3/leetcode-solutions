var maxFrequency = function(nums, k, numOperations) {
    nums.sort((a, b) => a - b);
    let left = 0, right = 0, total = 0, maxFreq = 0;

    while (right < nums.length) {
        total += nums[right];
        while (nums[right] * (right - left + 1) - total > k * numOperations) {
            total -= nums[left];
            left++;
        }
        maxFreq = Math.max(maxFreq, right - left + 1);
        right++;
    }

    return maxFreq;
};