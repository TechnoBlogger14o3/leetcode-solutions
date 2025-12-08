/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if (nums.length === 0) {
        return 0;
    }
    
    let writeIndex = 1;
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] !== nums[i - 1]) {
            nums[writeIndex] = nums[i];
            writeIndex++;
        }
    }
    
    return writeIndex;
};
