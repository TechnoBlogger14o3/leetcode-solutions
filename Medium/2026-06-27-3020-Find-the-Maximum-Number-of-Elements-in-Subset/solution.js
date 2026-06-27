var maximumSubsetSize = function(nums) {
    const count = new Map();
    
    for (const num of nums) {
        count.set(num, (count.get(num) || 0) + 1);
    }
    
    let maxSize = 0;
    
    for (const [num, freq] of count) {
        let currentSize = freq;
        let power = num;
        
        while (count.has(power * 2)) {
            currentSize += count.get(power * 2);
            power *= 2;
        }
        
        maxSize = Math.max(maxSize, currentSize);
    }
    
    return maxSize;
};