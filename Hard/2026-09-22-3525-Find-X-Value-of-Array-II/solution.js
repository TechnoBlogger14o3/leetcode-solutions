class Solution {
    findXValue(nums, k, queries) {
        const results = [];
        
        for (const [index, value, start, x] of queries) {
            nums[index] = value;
            let count = 0;
            let product = 1;

            for (let i = start; i < nums.length; i++) {
                product = (product * nums[i]) % k;
                if (product === x) {
                    count++;
                }
            }
            results.push(count);
        }
        
        return results;
    }
}