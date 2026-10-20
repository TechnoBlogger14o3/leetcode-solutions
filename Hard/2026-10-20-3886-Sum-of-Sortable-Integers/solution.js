var sumOfSortableIntegers = function(nums) {
    const n = nums.length;
    const sorted = [...nums].sort((a, b) => a - b);
    let sum = 0;

    const isSortable = (k) => {
        const groups = Array.from({ length: k }, () => []);
        for (let i = 0; i < n; i++) {
            groups[i % k].push(nums[i]);
        }
        for (let i = 0; i < k; i++) {
            groups[i].sort((a, b) => a - b);
        }
        const merged = [];
        for (let i = 0; i < n; i++) {
            merged.push(groups[i % k][Math.floor(i / k)]);
        }
        return merged.join(',') === sorted.join(',');
    };

    for (let k = 1; k <= n; k++) {
        if (n % k === 0 && isSortable(k)) {
            sum += k;
        }
    }

    return sum;
};