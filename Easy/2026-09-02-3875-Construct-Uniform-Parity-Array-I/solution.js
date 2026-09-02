function canConstructArray(nums1) {
    const isEven = nums1[0] % 2 === 0;
    for (let num of nums1) {
        if ((num % 2 === 0) !== isEven) {
            return true;
        }
    }
    return false;
}