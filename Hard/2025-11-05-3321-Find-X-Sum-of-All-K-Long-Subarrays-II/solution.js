var xSum = function(nums, k, x) {
    const n = nums.length;
    const result = new Array(n - k + 1);
    
    const getXSum = (subarray) => {
        const count = {};
        for (const num of subarray) {
            count[num] = (count[num] || 0) + 1;
        }
        
        const freqArray = Object.entries(count).map(([num, cnt]) => ({
            num: parseInt(num),
            cnt
        }));
        
        freqArray.sort((a, b) => b.cnt - a.cnt || b.num - a.num);
        
        const topX = freqArray.slice(0, x);
        const sum = topX.reduce((acc, { num, cnt }) => acc + num * cnt, 0);
        
        return sum;
    };
    
    for (let i = 0; i <= n - k; i++) {
        const subarray = nums.slice(i, i + k);
        result[i] = getXSum(subarray);
    }
    
    return result;
};