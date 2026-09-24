var smallestEqual = function(nums) {
    for (let i = 0; i < nums.length; i++) {
        let sumOfDigits = String(nums[i]).split('').reduce((acc, digit) => acc + Number(digit), 0);
        if (sumOfDigits === i) {
            return i;
        }
    }
    return -1;
};