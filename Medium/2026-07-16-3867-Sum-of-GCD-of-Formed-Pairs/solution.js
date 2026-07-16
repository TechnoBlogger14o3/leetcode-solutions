function gcd(a, b) {
    while (b) {
        [a, b] = [b, a % b];
    }
    return a;
}

function sumGCD(nums) {
    const n = nums.length;
    const prefixGcd = new Array(n);
    let maxNum = 0;

    for (let i = 0; i < n; i++) {
        maxNum = Math.max(maxNum, nums[i]);
        prefixGcd[i] = gcd(nums[i], maxNum);
    }

    prefixGcd.sort((a, b) => a - b);
    let sum = 0;

    for (let i = 0; i < Math.floor(n / 2); i++) {
        sum += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
    }

    return sum;
}