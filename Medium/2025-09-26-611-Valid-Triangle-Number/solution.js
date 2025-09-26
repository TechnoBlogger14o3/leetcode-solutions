var triangleNumber = function(nums) {
    nums.sort((a, b) => a - b);
    let count = 0;
    const n = nums.length;

    for (let i = 0; i < n - 2; i++) {
        let k = i + 2;
        for (let j = i + 1; j < n; j++) {
            while (k < n && nums[i] + nums[j] > nums[k]) {
                k++;
            }
            count += k - j - 1;
        }
    }
    
    return count;
};