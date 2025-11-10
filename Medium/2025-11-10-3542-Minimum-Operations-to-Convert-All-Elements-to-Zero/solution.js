var minimumOperations = function(nums) {
    const uniqueNums = new Set(nums);
    uniqueNums.delete(0);
    return uniqueNums.size;
};