var nextGreaterPermutation = function(s, target) {
    const sortedS = s.split('').sort().join('');
    
    const getNextPermutation = (str) => {
        const arr = str.split('');
        let i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) return null;

        let j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        [arr[i], arr[j]] = [arr[j], arr[i]];
        const reversedPart = arr.splice(i + 1).reverse();
        return arr.concat(reversedPart).join('');
    };

    let nextPerm = getNextPermutation(sortedS);
    while (nextPerm !== null) {
        if (nextPerm > target) {
            return nextPerm;
        }
        nextPerm = getNextPermutation(nextPerm);
    }
    return '';
};