var countTriplets = function(nums) {
    const MOD = 1e9 + 7;
    const count = new Map();
    let result = 0;

    for (const num of nums) {
        count.set(num, (count.get(num) || 0) + 1);
    }

    for (let j = 0; j < nums.length; j++) {
        const numJ = nums[j];
        const numI = numJ * 2;
        const numK = numJ * 2;

        if (count.has(numI) && count.has(numK)) {
            let countI = 0;
            let countK = 0;

            for (let i = 0; i < j; i++) {
                if (nums[i] === numI) countI++;
            }

            for (let k = j + 1; k < nums.length; k++) {
                if (nums[k] === numK) countK++;
            }

            result = (result + countI * countK) % MOD;
        }
    }

    return result;
};