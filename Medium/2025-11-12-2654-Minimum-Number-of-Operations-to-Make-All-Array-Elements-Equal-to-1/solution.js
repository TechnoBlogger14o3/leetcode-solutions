function minOperations(nums) {
    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
    
    let overallGCD = nums[0];
    for (let num of nums) {
        overallGCD = gcd(overallGCD, num);
    }
    
    if (overallGCD !== 1) return -1;

    let operations = 0;
    for (let i = 0; i < nums.length - 1; i++) {
        if (gcd(nums[i], nums[i + 1]) === 1) {
            operations += 1;
        }
    }
    
    return operations + (nums.length - 1);
}