var smallestUniqueSubarray = function(nums) {
    const n = nums.length;
    const count = new Map();
    const seen = new Set();
    let minLength = Infinity;

    for (let i = 0; i < n; i++) {
        count.set(nums[i], (count.get(nums[i]) || 0) + 1);
    }

    for (let length = 1; length <= n; length++) {
        seen.clear();
        let unique = true;

        for (let start = 0; start <= n - length; start++) {
            const subarray = nums.slice(start, start + length).toString();
            if (seen.has(subarray)) {
                unique = false;
                break;
            }
            seen.add(subarray);
        }

        if (unique) {
            minLength = Math.min(minLength, length);
        }
    }

    return minLength === Infinity ? -1 : minLength;
};