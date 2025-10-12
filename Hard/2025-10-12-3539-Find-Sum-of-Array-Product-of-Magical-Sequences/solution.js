class Solution {
    static MOD = 1e9 + 7;

    findSum(m, k, nums) {
        const n = nums.length;
        const dp = Array.from({ length: m + 1 }, () => Array(1 << n).fill(0));
        dp[0][0] = 1;

        for (let i = 0; i < m; i++) {
            for (let mask = 0; mask < (1 << n); mask++) {
                if (dp[i][mask] === 0) continue;
                for (let j = 0; j < n; j++) {
                    const newMask = mask | (1 << j);
                    dp[i + 1][newMask] = (dp[i + 1][newMask] + dp[i][mask]) % Solution.MOD;
                }
            }
        }

        let result = 0;
        for (let mask = 0; mask < (1 << n); mask++) {
            if (this.countSetBits(mask) === k) {
                let product = 1;
                for (let j = 0; j < n; j++) {
                    if (mask & (1 << j)) {
                        product = (product * nums[j]) % Solution.MOD;
                    }
                }
                result = (result + product) % Solution.MOD;
            }
        }

        return result;
    }

    countSetBits(num) {
        let count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}