var smallestStableIndex = function(nums, k) {
    const n = nums.length;
    let maxLeft = Array(n).fill(0);
    let minRight = Array(n).fill(0);

    maxLeft[0] = nums[0];
    for (let i = 1; i < n; i++) {
        maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
    }

    minRight[n - 1] = nums[n - 1];
    for (let i = n - 2; i >= 0; i--) {
        minRight[i] = Math.min(minRight[i + 1], nums[i]);
    }

    for (let i = 0; i < n; i++) {
        if (maxLeft[i] - minRight[i] <= k) {
            return i;
        }
    }

    return -1;
};