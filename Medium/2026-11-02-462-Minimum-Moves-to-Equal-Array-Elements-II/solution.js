var minMoves2 = function(nums) {
    nums.sort((a, b) => a - b);
    const median = nums[Math.floor(nums.length / 2)];
    return nums.reduce((acc, num) => acc + Math.abs(num - median), 0);
};