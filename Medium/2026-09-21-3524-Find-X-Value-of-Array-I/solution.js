var findXValue = function(nums, k) {
    const result = new Array(k).fill(0);
    const n = nums.length;

    for (let i = 0; i < n; i++) {
        let product = 1;
        for (let j = i; j < n; j++) {
            product = (product * nums[j]) % k;
            result[product]++;
        }
    }

    return result;
};