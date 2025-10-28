var countValidSelections = function(nums) {
    const n = nums.length;
    let validCount = 0;

    for (let start = 0; start < n; start++) {
        if (nums[start] === 0) {
            for (let direction = -1; direction <= 1; direction += 2) {
                let curr = start;
                const tempNums = [...nums];
                let valid = true;

                while (valid && curr >= 0 && curr < n) {
                    if (tempNums[curr] === 0) {
                        curr += direction;
                    } else {
                        tempNums[curr]--;
                        direction *= -1; // reverse direction
                        curr += direction;
                    }
                }

                if (valid && curr < 0 || curr >= n) {
                    validCount++;
                }
            }
        }
    }

    return validCount;
};