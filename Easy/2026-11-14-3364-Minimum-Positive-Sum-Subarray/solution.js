var minPositiveSumSubarray = function(nums, l, r) {
    let minSum = Infinity;
    const n = nums.length;

    for (let size = l; size <= r; size++) {
        let currentSum = 0;

        for (let i = 0; i < size; i++) {
            currentSum += nums[i];
        }

        if (currentSum > 0) {
            minSum = Math.min(minSum, currentSum);
        }

        for (let i = size; i < n; i++) {
            currentSum += nums[i] - nums[i - size];
            if (currentSum > 0) {
                minSum = Math.min(minSum, currentSum);
            }
        }
    }

    return minSum === Infinity ? -1 : minSum;
};