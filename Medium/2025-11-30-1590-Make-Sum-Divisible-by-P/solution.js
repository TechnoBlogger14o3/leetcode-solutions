var minSubarray = function(nums, p) {
    const totalSum = nums.reduce((a, b) => a + b, 0);
    const remainder = totalSum % p;

    if (remainder === 0) return 0;

    const n = nums.length;
    const map = new Map();
    map.set(0, -1);
    let currentSum = 0;
    let minLength = Infinity;

    for (let i = 0; i < n; i++) {
        currentSum += nums[i];
        const mod = currentSum % p;

        if (map.has((mod - remainder + p) % p)) {
            minLength = Math.min(minLength, i - map.get((mod - remainder + p) % p));
        }

        map.set(mod, i);
    }

    return minLength === Infinity ? -1 : minLength;
};