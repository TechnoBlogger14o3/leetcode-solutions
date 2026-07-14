class Solution {
    findValidPairs(nums) {
        const MOD = 1e9 + 7;
        const maxNum = 200;
        const count = new Array(maxNum + 1).fill(0);
        
        for (const num of nums) {
            count[num]++;
        }
        
        const totalSubsequences = new Array(maxNum + 1).fill(0);
        
        for (let g = 1; g <= maxNum; g++) {
            let subseqCount = 0;
            for (let multiple = g; multiple <= maxNum; multiple += g) {
                subseqCount += count[multiple];
            }
            if (subseqCount > 0) {
                totalSubsequences[g] = (1 << subseqCount) - 1; // 2^subseqCount - 1
            }
        }
        
        let result = 0;
        
        for (let g = 1; g <= maxNum; g++) {
            if (totalSubsequences[g] > 0) {
                result = (result + totalSubsequences[g] * totalSubsequences[g]) % MOD;
            }
        }
        
        return result;
    }
    
    numOfSubseqs(nums) {
        return this.findValidPairs(nums);
    }
}