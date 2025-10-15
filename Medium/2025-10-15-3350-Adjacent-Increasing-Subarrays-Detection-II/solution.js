var maxK = function(nums) {
    const n = nums.length;
    let maxK = 0;
    const lengths = new Array(n).fill(0);

    // Calculate lengths of strictly increasing subarrays
    for (let i = 1; i < n; i++) {
        if (nums[i] > nums[i - 1]) {
            lengths[i] = lengths[i - 1] + 1;
        }
    }

    // Find the maximum k for adjacent strictly increasing subarrays
    for (let i = 1; i < n; i++) {
        if (lengths[i] > 0 && lengths[i - 1] > 0) {
            const k = Math.min(lengths[i], lengths[i - 1]) + 1;
            maxK = Math.max(maxK, k);
        }
    }

    return maxK;
};