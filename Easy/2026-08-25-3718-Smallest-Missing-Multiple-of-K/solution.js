var findSmallestInteger = function(nums, k) {
    const numSet = new Set(nums);
    let multiple = k;
    
    while (numSet.has(multiple)) {
        multiple += k;
    }
    
    return multiple;
};