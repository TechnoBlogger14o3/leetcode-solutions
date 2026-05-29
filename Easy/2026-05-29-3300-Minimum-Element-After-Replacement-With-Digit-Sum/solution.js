var minimumElement = function(nums) {
    const digitSum = (num) => {
        let sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = Math.floor(num / 10);
        }
        return sum;
    };

    let minElement = Infinity;
    for (let num of nums) {
        minElement = Math.min(minElement, digitSum(num));
    }
    
    return minElement;
};