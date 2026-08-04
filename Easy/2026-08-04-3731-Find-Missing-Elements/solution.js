var findMissingElements = function(nums) {
    const minNum = Math.min(...nums);
    const maxNum = Math.max(...nums);
    const missing = [];
    
    for (let i = minNum; i <= maxNum; i++) {
        if (!nums.includes(i)) {
            missing.push(i);
        }
    }
    
    return missing;
};