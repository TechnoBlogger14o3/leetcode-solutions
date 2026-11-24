function maxProductEquivalentSubarray(nums) {
    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
    const lcm = (a, b) => (a * b) / gcd(a, b);
    
    const n = nums.length;
    let maxLength = 0;

    for (let start = 0; start < n; start++) {
        let product = 1;
        let currentGCD = nums[start];
        let currentLCM = nums[start];
        for (let end = start; end < n; end++) {
            product *= nums[end];
            currentGCD = gcd(currentGCD, nums[end]);
            currentLCM = lcm(currentLCM, nums[end]);
            
            if (product === currentGCD * currentLCM) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }
    }

    return maxLength;
}