function hasAdjacentIncreasingSubarrays(nums, k) {
    const n = nums.length;

    const isStrictlyIncreasing = (start) => {
        for (let i = start; i < start + k - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    };

    for (let i = 0; i <= n - 2 * k; i++) {
        if (isStrictlyIncreasing(i) && isStrictlyIncreasing(i + k)) {
            return true;
        }
    }

    return false;
}