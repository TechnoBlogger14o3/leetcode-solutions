var minOperations = function(target) {
    let operations = 0;
    for (let i = 0; i < target.length; i++) {
        if (i === 0) {
            operations += target[i];
        } else {
            operations += Math.max(0, target[i] - target[i - 1]);
        }
    }
    return operations;
};