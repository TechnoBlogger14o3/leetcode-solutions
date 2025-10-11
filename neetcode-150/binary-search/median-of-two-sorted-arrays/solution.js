/**
 * Time Complexity: O(log(min(m,n))) - Binary search on smaller array
 * Space Complexity: O(1) - Only uses constant extra space
 */
var findMedianSortedArrays = function(nums1, nums2) {
    // Ensure nums1 is the smaller array
    if (nums1.length > nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
    }
    
    const m = nums1.length;
    const n = nums2.length;
    let left = 0;
    let right = m;
    
    while (left <= right) {
        const partitionX = Math.floor(left + (right - left) / 2);
        const partitionY = Math.floor((m + n + 1) / 2) - partitionX;
        
        const maxLeftX = partitionX === 0 ? Number.MIN_SAFE_INTEGER : nums1[partitionX - 1];
        const minRightX = partitionX === m ? Number.MAX_SAFE_INTEGER : nums1[partitionX];
        
        const maxLeftY = partitionY === 0 ? Number.MIN_SAFE_INTEGER : nums2[partitionY - 1];
        const minRightY = partitionY === n ? Number.MAX_SAFE_INTEGER : nums2[partitionY];
        
        if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
            // Found correct partition
            if ((m + n) % 2 === 0) {
                return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
            } else {
                return Math.max(maxLeftX, maxLeftY);
            }
        } else if (maxLeftX > minRightY) {
            right = partitionX - 1;
        } else {
            left = partitionX + 1;
        }
    }
    
    throw new Error("Input arrays are not sorted");
};

// Alternative approach using merge
var findMedianSortedArraysMerge = function(nums1, nums2) {
    const m = nums1.length;
    const n = nums2.length;
    const merged = new Array(m + n);
    
    let i = 0, j = 0, k = 0;
    
    while (i < m && j < n) {
        if (nums1[i] <= nums2[j]) {
            merged[k++] = nums1[i++];
        } else {
            merged[k++] = nums2[j++];
        }
    }
    
    while (i < m) {
        merged[k++] = nums1[i++];
    }
    
    while (j < n) {
        merged[k++] = nums2[j++];
    }
    
    const total = m + n;
    if (total % 2 === 0) {
        return (merged[total / 2 - 1] + merged[total / 2]) / 2;
    } else {
        return merged[Math.floor(total / 2)];
    }
};

// More concise version
var findMedianSortedArraysConcise = function(nums1, nums2) {
    if (nums1.length > nums2.length) {
        return findMedianSortedArraysConcise(nums2, nums1);
    }
    
    const m = nums1.length, n = nums2.length;
    let left = 0, right = m;
    
    while (left <= right) {
        const partitionX = Math.floor((left + right) / 2);
        const partitionY = Math.floor((m + n + 1) / 2) - partitionX;
        
        const maxLeftX = partitionX === 0 ? Number.MIN_SAFE_INTEGER : nums1[partitionX - 1];
        const minRightX = partitionX === m ? Number.MAX_SAFE_INTEGER : nums1[partitionX];
        const maxLeftY = partitionY === 0 ? Number.MIN_SAFE_INTEGER : nums2[partitionY - 1];
        const minRightY = partitionY === n ? Number.MAX_SAFE_INTEGER : nums2[partitionY];
        
        if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
            if ((m + n) % 2 === 0) {
                return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
            } else {
                return Math.max(maxLeftX, maxLeftY);
            }
        } else if (maxLeftX > minRightY) {
            right = partitionX - 1;
        } else {
            left = partitionX + 1;
        }
    }
    
    throw new Error("Input arrays are not sorted");
};

// Using bit manipulation for mid calculation
var findMedianSortedArraysBitManipulation = function(nums1, nums2) {
    if (nums1.length > nums2.length) {
        return findMedianSortedArraysBitManipulation(nums2, nums1);
    }
    
    const m = nums1.length;
    const n = nums2.length;
    let left = 0;
    let right = m;
    
    while (left <= right) {
        const partitionX = (left + right) >>> 1; // Unsigned right shift
        
        const partitionY = Math.floor((m + n + 1) / 2) - partitionX;
        
        const maxLeftX = partitionX === 0 ? Number.MIN_SAFE_INTEGER : nums1[partitionX - 1];
        const minRightX = partitionX === m ? Number.MAX_SAFE_INTEGER : nums1[partitionX];
        
        const maxLeftY = partitionY === 0 ? Number.MIN_SAFE_INTEGER : nums2[partitionY - 1];
        const minRightY = partitionY === n ? Number.MAX_SAFE_INTEGER : nums2[partitionY];
        
        if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
            if ((m + n) % 2 === 0) {
                return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
            } else {
                return Math.max(maxLeftX, maxLeftY);
            }
        } else if (maxLeftX > minRightY) {
            right = partitionX - 1;
        } else {
            left = partitionX + 1;
        }
    }
    
    throw new Error("Input arrays are not sorted");
};
