var findDifferentBinaryString = function(nums) {
    const n = nums.length;
    let uniqueString = '';

    for (let i = 0; i < n; i++) {
        uniqueString += nums[i][i] === '0' ? '1' : '0';
    }

    return uniqueString;
};