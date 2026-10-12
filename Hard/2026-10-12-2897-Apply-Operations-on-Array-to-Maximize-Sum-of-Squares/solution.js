var maximumSumOfSquares = function(nums, k) {
    const MOD = 1e9 + 7;
    
    // Sort the array in descending order
    nums.sort((a, b) => b - a);
    
    // Take the first k elements
    const topK = nums.slice(0, k);
    
    // Calculate the sum of squares
    let sum = 0;
    for (let num of topK) {
        sum = (sum + num * num) % MOD;
    }
    
    return sum;
};