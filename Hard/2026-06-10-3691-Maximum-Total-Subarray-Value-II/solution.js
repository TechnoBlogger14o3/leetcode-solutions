class Solution {
    maximumTotalValue(nums, k) {
        const n = nums.length;
        const values = [];
        
        for (let l = 0; l < n; l++) {
            let maxVal = nums[l];
            let minVal = nums[l];
            for (let r = l; r < n; r++) {
                maxVal = Math.max(maxVal, nums[r]);
                minVal = Math.min(minVal, nums[r]);
                values.push(maxVal - minVal);
            }
        }
        
        values.sort((a, b) => b - a);
        return values.slice(0, k).reduce((sum, value) => sum + value, 0);
    }
}