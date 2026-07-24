var uniqueTriplets = function(nums) {
    const uniqueXORs = new Set();
    const n = nums.length;

    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            for (let k = j; k < n; k++) {
                const xorValue = nums[i] ^ nums[j] ^ nums[k];
                uniqueXORs.add(xorValue);
            }
        }
    }

    return uniqueXORs.size;
};