var findTheDistanceValue = function(arr1, arr2, d) {
    let count = 0;

    for (let num1 of arr1) {
        let isValid = true;
        for (let num2 of arr2) {
            if (Math.abs(num1 - num2) <= d) {
                isValid = false;
                break;
            }
        }
        if (isValid) count++;
    }

    return count;
};