var findDuplicates = function(nums) {
    const seen = new Set();
    const duplicates = [];
    
    for (const num of nums) {
        if (seen.has(num)) {
            duplicates.push(num);
        } else {
            seen.add(num);
        }
    }
    
    return duplicates;
};