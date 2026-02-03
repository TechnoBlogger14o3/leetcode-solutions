var isTrionic = function(nums) {
    const n = nums.length;
    if (n < 3) return false;

    let p = -1, q = -1;

    // Find p
    for (let i = 1; i < n; i++) {
        if (nums[i] > nums[i - 1]) {
            p = i;
        } else {
            break;
        }
    }

    // If p is not found or it's the first or last index
    if (p <= 0 || p >= n - 1) return false;

    // Find q
    for (let i = p + 1; i < n; i++) {
        if (nums[i] < nums[i - 1]) {
            q = i;
        } else {
            break;
        }
    }

    // If q is not found or it's the last index
    if (q <= p || q >= n - 1) return false;

    // Check if the last part is strictly increasing
    for (let i = q + 1; i < n; i++) {
        if (nums[i] <= nums[i - 1]) {
            return false;
        }
    }

    return true;
};