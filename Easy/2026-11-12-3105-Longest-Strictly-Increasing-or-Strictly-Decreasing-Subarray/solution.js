var longestSubarray = function(nums) {
    let maxLength = 1;
    let currentLength = 1;
    let increasing = null;

    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i - 1]) {
            if (increasing === false) {
                currentLength = 2;
            } else {
                currentLength++;
            }
            increasing = true;
        } else if (nums[i] < nums[i - 1]) {
            if (increasing === true) {
                currentLength = 2;
            } else {
                currentLength++;
            }
            increasing = false;
        } else {
            currentLength = 1;
            increasing = null;
        }
        maxLength = Math.max(maxLength, currentLength);
    }

    return maxLength;
};