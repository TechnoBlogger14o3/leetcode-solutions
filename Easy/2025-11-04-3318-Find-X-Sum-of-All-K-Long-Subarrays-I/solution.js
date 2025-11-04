var xSum = function(nums, k, x) {
    const n = nums.length;
    const answer = new Array(n - k + 1);
    
    for (let i = 0; i <= n - k; i++) {
        const subarray = nums.slice(i, i + k);
        const freqMap = new Map();
        
        for (const num of subarray) {
            freqMap.set(num, (freqMap.get(num) || 0) + 1);
        }
        
        const sortedFreq = Array.from(freqMap.entries())
            .sort((a, b) => b[1] - a[1] || b[0] - a[0])
            .slice(0, x);
        
        const sum = sortedFreq.reduce((acc, [num, count]) => acc + num * count, 0);
        answer[i] = sum;
    }
    
    return answer;
};