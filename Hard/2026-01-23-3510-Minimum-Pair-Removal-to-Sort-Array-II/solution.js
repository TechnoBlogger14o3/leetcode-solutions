var minimumOperations = function(nums) {
    let operations = 0;
    let n = nums.length;

    while (true) {
        let minSum = Infinity;
        let minIndex = -1;

        for (let i = 0; i < n - 1; i++) {
            if (nums[i] + nums[i + 1] < minSum) {
                minSum = nums[i] + nums[i + 1];
                minIndex = i;
            }
        }

        if (minIndex === -1) break;

        let newValue = nums[minIndex] + nums[minIndex + 1];
        nums[minIndex] = newValue;
        nums.splice(minIndex + 1, 1);
        operations++;

        if (isSorted(nums)) break;
    }

    return operations;
};

function isSorted(arr) {
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] < arr[i - 1]) return false;
    }
    return true;
}