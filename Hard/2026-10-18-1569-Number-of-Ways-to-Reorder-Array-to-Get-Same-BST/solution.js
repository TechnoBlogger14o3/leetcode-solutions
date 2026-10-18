var numOfWays = function(nums) {
    const MOD = 1e9 + 7;

    const comb = (n, k) => {
        if (k > n) return 0;
        let res = 1;
        for (let i = 0; i < k; i++) {
            res = (res * (n - i)) % MOD;
            res = (res * modInverse(i + 1, MOD)) % MOD;
        }
        return res;
    };

    const modInverse = (a, p) => {
        let m0 = p, y = 0, x = 1;
        if (p === 1) return 0;
        while (a > 1) {
            let q = Math.floor(a / p);
            let t = p;
            p = a % p, a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        return (x + m0) % m0;
    };

    const countWays = (left, right) => {
        if (left >= right) return 1;
        let root = nums[left];
        let leftCount = 0;
        let rightCount = 0;

        for (let i = left + 1; i <= right; i++) {
            if (nums[i] < root) leftCount++;
            else rightCount++;
        }

        let totalWays = (countWays(left + 1, left + leftCount) * countWays(left + leftCount + 1, right)) % MOD;
        totalWays = (totalWays * comb(leftCount + rightCount, leftCount)) % MOD;

        return totalWays;
    };

    return countWays(0, nums.length - 1);
};