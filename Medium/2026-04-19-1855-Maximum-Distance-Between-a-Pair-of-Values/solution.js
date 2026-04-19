var maxDistance = function(nums1, nums2) {
    let maxDist = 0;
    let j = 0;
    
    for (let i = 0; i < nums1.length; i++) {
        while (j < nums2.length && nums1[i] <= nums2[j]) {
            j++;
        }
        maxDist = Math.max(maxDist, j - 1 - i);
    }
    
    return maxDist;
};