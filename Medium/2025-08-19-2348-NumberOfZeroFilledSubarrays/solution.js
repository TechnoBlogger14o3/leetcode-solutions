/**
 * @param {number[]} nums
 * @return {number}
 */
var zeroFilledSubarray = function(nums) {
    let count = 0;
    let consecutiveZeros = 0;
    
    for (let num of nums) {
        if (num === 0) {
            consecutiveZeros++;
            // Add the count of all subarrays ending at current position
            count += consecutiveZeros;
        } else {
            consecutiveZeros = 0;
        }
    }
    
    return count;
};
