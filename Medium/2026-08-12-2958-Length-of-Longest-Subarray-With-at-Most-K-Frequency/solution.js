var longestSubarray = function(nums, k) {
    let left = 0, maxLength = 0;
    const frequency = new Map();

    for (let right = 0; right < nums.length; right++) {
        frequency.set(nums[right], (frequency.get(nums[right]) || 0) + 1);

        while (frequency.get(nums[right]) > k) {
            frequency.set(nums[left], frequency.get(nums[left]) - 1);
            if (frequency.get(nums[left]) === 0) {
                frequency.delete(nums[left]);
            }
            left++;
        }

        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
};