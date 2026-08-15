var longestSubsequence = function(nums) {
    let count = 0;
    let totalXor = 0;

    for (let num of nums) {
        totalXor ^= num;
        if (num !== 0) {
            count++;
        }
    }

    return totalXor === 0 ? count - 1 : count;
};