function minOperations(nums) {
    let operations = 0;
    for (let num of nums) {
        const remainder = num % 3;
        if (remainder !== 0) {
            operations += Math.min(remainder, 3 - remainder);
        }
    }
    return operations;
}