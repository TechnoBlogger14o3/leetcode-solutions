var prefixesDivBy5 = function(nums) {
    let result = [];
    let current = 0;

    for (let num of nums) {
        current = ((current << 1) + num) % 5;
        result.push(current === 0);
    }

    return result;
};