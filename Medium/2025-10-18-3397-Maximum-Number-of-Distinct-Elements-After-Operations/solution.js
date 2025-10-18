var maximumDistinctElements = function(nums, k) {
    const numSet = new Set(nums);
    const distinctCount = numSet.size;
    const maxPossible = distinctCount + k;

    const minNum = Math.min(...numSet);
    const maxNum = Math.max(...numSet);
    const range = maxNum - minNum + 1;

    return Math.min(maxPossible, range);
};