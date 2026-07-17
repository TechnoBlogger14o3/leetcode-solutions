class Solution {
    gcd(a, b) {
        while (b) {
            [a, b] = [b, a % b];
        }
        return a;
    }

    sortedGcdPairQueries(nums, queries) {
        const n = nums.length;
        const gcdPairs = [];

        for (let i = 0; i < n; i++) {
            for (let j = i + 1; j < n; j++) {
                gcdPairs.push(this.gcd(nums[i], nums[j]));
            }
        }

        gcdPairs.sort((a, b) => a - b);
        
        return queries.map(q => gcdPairs[q]);
    }
}