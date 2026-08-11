function smallestMissingInteger(nums) {
    let longestSum = 0;
    let currentSum = 0;
    let currentStart = nums[0];

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === currentStart) {
            currentSum += nums[i];
            currentStart++;
        } else {
            longestSum = Math.max(longestSum, currentSum);
            currentSum = nums[i] === currentStart ? nums[i] : 0;
            currentStart = nums[i] + 1;
        }
    }
    longestSum = Math.max(longestSum, currentSum);

    const numSet = new Set(nums);
    let missingInteger = longestSum;

    while (numSet.has(missingInteger)) {
        missingInteger++;
    }

    return missingInteger;
}