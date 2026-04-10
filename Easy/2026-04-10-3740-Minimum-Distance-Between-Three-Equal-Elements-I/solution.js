var minimumDistance = function(nums) {
    const indices = new Map();
    let minDistance = Infinity;

    for (let i = 0; i < nums.length; i++) {
        if (!indices.has(nums[i])) {
            indices.set(nums[i], []);
        }
        indices.get(nums[i]).push(i);
    }

    for (const indexList of indices.values()) {
        if (indexList.length >= 3) {
            for (let i = 0; i < indexList.length - 2; i++) {
                for (let j = i + 1; j < indexList.length - 1; j++) {
                    for (let k = j + 1; k < indexList.length; k++) {
                        const distance = Math.abs(indexList[i] - indexList[j]) +
                                         Math.abs(indexList[j] - indexList[k]) +
                                         Math.abs(indexList[k] - indexList[i]);
                        minDistance = Math.min(minDistance, distance);
                    }
                }
            }
        }
    }

    return minDistance === Infinity ? -1 : minDistance;
};