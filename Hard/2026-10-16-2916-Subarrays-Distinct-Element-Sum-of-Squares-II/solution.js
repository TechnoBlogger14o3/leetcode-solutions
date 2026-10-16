class Solution {
    sumOfSquares(nums) {
        const MOD = 1e9 + 7;
        const n = nums.length;
        let result = 0;
        let left = 0;
        const count = new Map();
        
        for (let right = 0; right < n; right++) {
            count.set(nums[right], (count.get(nums[right]) || 0) + 1);
            
            while (count.get(nums[right]) > 1) {
                count.set(nums[left], count.get(nums[left]) - 1);
                if (count.get(nums[left]) === 0) {
                    count.delete(nums[left]);
                }
                left++;
            }
            
            const distinctCount = right - left + 1;
            result = (result + distinctCount * distinctCount) % MOD;
        }
        
        return result;
    }
}