class Solution {
    countSubmat(grid, k) {
        const m = grid.length;
        const n = grid[0].length;
        let count = 0;

        for (let right = 0; right < n; right++) {
            const sums = new Array(m).fill(0);
            for (let left = right; left >= 0; left--) {
                for (let row = 0; row < m; row++) {
                    sums[row] += grid[row][left];
                }

                count += this.countLessThanK(sums, k);
            }
        }

        return count;
    }

    countLessThanK(sums, k) {
        let count = 0;
        const prefixSum = [0];
        let currentSum = 0;

        for (const sum of sums) {
            currentSum += sum;
            const target = currentSum - k;

            let left = 0;
            let right = prefixSum.length;

            while (left < right) {
                const mid = Math.floor((left + right) / 2);
                if (prefixSum[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            count += left;
            prefixSum.push(currentSum);
        }

        return count;
    }
}