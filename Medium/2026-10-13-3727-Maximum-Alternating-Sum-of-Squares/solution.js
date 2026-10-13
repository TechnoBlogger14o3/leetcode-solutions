var maximumAlternatingSum = function(nums) {
    nums.sort((a, b) => b - a);
    let score = 0;
    for (let i = 0; i < nums.length; i++) {
        if (i % 2 === 0) {
            score += nums[i] * nums[i];
        } else {
            score -= nums[i] * nums[i];
        }
    }
    return score;
};