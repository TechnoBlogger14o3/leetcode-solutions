var distinctElementSumOfSquares = function(nums) {
    const n = nums.length;
    let totalSum = 0;

    for (let i = 0; i < n; i++) {
        const seen = new Set();
        for (let j = i; j < n; j++) {
            seen.add(nums[j]);
            totalSum += seen.size ** 2;
        }
    }

    return totalSum;
};