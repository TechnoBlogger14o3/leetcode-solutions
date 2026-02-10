var longestBalancedSubarray = function(nums) {
    let left = 0, right = 0, maxLength = 0;
    const evenCount = new Map();
    const oddCount = new Map();

    while (right < nums.length) {
        if (nums[right] % 2 === 0) {
            evenCount.set(nums[right], (evenCount.get(nums[right]) || 0) + 1);
        } else {
            oddCount.set(nums[right], (oddCount.get(nums[right]) || 0) + 1);
        }

        while (evenCount.size !== oddCount.size) {
            if (nums[left] % 2 === 0) {
                evenCount.set(nums[left], evenCount.get(nums[left]) - 1);
                if (evenCount.get(nums[left]) === 0) {
                    evenCount.delete(nums[left]);
                }
            } else {
                oddCount.set(nums[left], oddCount.get(nums[left]) - 1);
                if (oddCount.get(nums[left]) === 0) {
                    oddCount.delete(nums[left]);
                }
            }
            left++;
        }

        maxLength = Math.max(maxLength, right - left + 1);
        right++;
    }

    return maxLength;
};