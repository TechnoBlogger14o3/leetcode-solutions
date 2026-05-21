var longestCommonPrefix = function(arr1, arr2) {
    let maxLength = 0;

    for (let num1 of arr1) {
        for (let num2 of arr2) {
            let str1 = num1.toString();
            let str2 = num2.toString();
            let commonLength = 0;

            while (commonLength < str1.length && commonLength < str2.length && str1[commonLength] === str2[commonLength]) {
                commonLength++;
            }

            maxLength = Math.max(maxLength, commonLength);
        }
    }

    return maxLength;
};