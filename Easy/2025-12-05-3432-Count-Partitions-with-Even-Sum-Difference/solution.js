var countPartitions = function(nums) {
    let n = nums.length;
    let leftSum = 0;
    let rightSum = nums.reduce((a, b) => a + b, 0);
    let count = 0;

    for (let i = 0; i < n - 1; i++) {
        leftSum += nums[i];
        rightSum -= nums[i];

        if ((leftSum - rightSum) % 2 === 0) {
            count++;
        }
    }

    return count;
};