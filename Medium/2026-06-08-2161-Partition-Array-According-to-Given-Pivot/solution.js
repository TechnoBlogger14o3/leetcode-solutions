var pivotArray = function(nums, pivot) {
    const less = [];
    const equal = [];
    const greater = [];
    
    for (const num of nums) {
        if (num < pivot) {
            less.push(num);
        } else if (num === pivot) {
            equal.push(num);
        } else {
            greater.push(num);
        }
    }
    
    return [...less, ...equal, ...greater];
};