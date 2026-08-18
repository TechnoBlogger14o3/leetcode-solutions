var findLargestMissingInteger = function(nums, k) {
    const countMap = new Map();
    const n = nums.length;

    for (let i = 0; i <= n - k; i++) {
        const subarray = new Set(nums.slice(i, i + k));
        subarray.forEach(num => {
            countMap.set(num, (countMap.get(num) || 0) + 1);
        });
    }

    let largestAlmostMissing = -1;
    for (const [num, count] of countMap.entries()) {
        if (count === 1) {
            largestAlmostMissing = Math.max(largestAlmostMissing, num);
        }
    }

    return largestAlmostMissing;
};