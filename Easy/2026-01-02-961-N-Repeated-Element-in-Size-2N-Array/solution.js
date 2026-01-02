var repeatedNTimes = function(nums) {
    const count = {};
    for (const num of nums) {
        if (count[num]) {
            return num;
        }
        count[num] = 1;
    }
};