var numOfSubarrays = function(arr) {
    const MOD = 1e9 + 7;
    let oddCount = 0, evenCount = 1, currentSum = 0, result = 0;

    for (let num of arr) {
        currentSum += num;
        if (currentSum % 2 === 0) {
            result = (result + oddCount) % MOD;
            evenCount++;
        } else {
            result = (result + evenCount) % MOD;
            oddCount++;
        }
    }

    return result;
};