var minimumAbsDistance = function(nums) {
    const reverse = (num) => parseInt(num.toString().split('').reverse().join(''), 10);
    const indexMap = new Map();
    let minDistance = Infinity;

    for (let i = 0; i < nums.length; i++) {
        const revNum = reverse(nums[i]);
        if (indexMap.has(revNum)) {
            const prevIndex = indexMap.get(revNum);
            minDistance = Math.min(minDistance, i - prevIndex);
        }
        indexMap.set(nums[i], i);
    }

    return minDistance === Infinity ? -1 : minDistance;
};