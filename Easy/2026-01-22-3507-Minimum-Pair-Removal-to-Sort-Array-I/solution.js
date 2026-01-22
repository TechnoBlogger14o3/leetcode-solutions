var minimumOperations = function(nums) {
    let operations = 0;

    while (true) {
        let found = false;
        let minSum = Infinity;
        let minIndex = -1;

        for (let i = 0; i < nums.length - 1; i++) {
            let sum = nums[i] + nums[i + 1];
            if (sum < minSum) {
                minSum = sum;
                minIndex = i;
                found = true;
            }
        }

        if (!found) break;

        let newNum = nums[minIndex] + nums[minIndex + 1];
        nums.splice(minIndex, 2, newNum);
        operations++;
        
        if (isNonDecreasing(nums)) break;
    }

    return operations;
};

function isNonDecreasing(arr) {
    for (let i = 1; i < arr.length; i++) {
        if (arr[i] < arr[i - 1]) {
            return false;
        }
    }
    return true;
}