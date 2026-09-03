var canConstructArray = function(nums1) {
    let oddCount = 0;
    let evenCount = 0;

    for (let num of nums1) {
        if (num % 2 === 0) {
            evenCount++;
        } else {
            oddCount++;
        }
    }

    return oddCount === nums1.length || evenCount === nums1.length;
};