var countMaxFrequency = function(nums) {
    const frequencyMap = new Map();
    
    for (const num of nums) {
        frequencyMap.set(num, (frequencyMap.get(num) || 0) + 1);
    }
    
    let maxFrequency = 0;
    for (const freq of frequencyMap.values()) {
        maxFrequency = Math.max(maxFrequency, freq);
    }
    
    let totalCount = 0;
    for (const [num, freq] of frequencyMap.entries()) {
        if (freq === maxFrequency) {
            totalCount += freq;
        }
    }
    
    return totalCount;
};