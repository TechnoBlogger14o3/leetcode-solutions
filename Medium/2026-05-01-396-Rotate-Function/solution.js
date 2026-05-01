var maxRotateFunction = function(nums) {
    const n = nums.length;
    let F = 0;
    let totalSum = 0;

    for (let i = 0; i < n; i++) {
        F += i * nums[i];
        totalSum += nums[i];
    }

    let maxF = F;

    for (let k = 1; k < n; k++) {
        F = F + totalSum - n * nums[n - k];
        maxF = Math.max(maxF, F);
    }

    return maxF;
};