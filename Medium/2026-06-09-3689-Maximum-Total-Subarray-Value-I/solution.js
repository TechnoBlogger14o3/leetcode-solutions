var maximumTotalValue = function(nums, k) {
    const n = nums.length;
    let maxVal = Math.max(...nums);
    let minVal = Math.min(...nums);
    let totalValue = (maxVal - minVal) * k;
    return totalValue;
};