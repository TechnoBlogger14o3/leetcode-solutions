class Solution {
    minJumps(nums) {
        const n = nums.length;
        if (n === 1) return 0;

        const isPrime = (num) => {
            if (num < 2) return false;
            for (let i = 2; i * i <= num; i++) {
                if (num % i === 0) return false;
            }
            return true;
        };

        const primeIndices = new Map();
        for (let i = 0; i < n; i++) {
            if (isPrime(nums[i])) {
                if (!primeIndices.has(nums[i])) {
                    primeIndices.set(nums[i], []);
                }
                primeIndices.get(nums[i]).push(i);
            }
        }

        const queue = [0];
        const visited = new Set([0]);
        let jumps = 0;

        while (queue.length) {
            const size = queue.length;
            for (let i = 0; i < size; i++) {
                const index = queue.shift();
                if (index === n - 1) return jumps;

                // Adjacent steps
                if (index + 1 < n && !visited.has(index + 1)) {
                    visited.add(index + 1);
                    queue.push(index + 1);
                }
                if (index - 1 >= 0 && !visited.has(index - 1)) {
                    visited.add(index - 1);
                    queue.push(index - 1);
                }

                // Prime teleportation
                if (isPrime(nums[index])) {
                    const indices = primeIndices.get(nums[index]);
                    for (const j of indices) {
                        if (j !== index && !visited.has(j)) {
                            visited.add(j);
                            queue.push(j);
                        }
                    }
                    // Clear the list to prevent future unnecessary checks
                    primeIndices.delete(nums[index]);
                }
            }
            jumps++;
        }

        return -1; // Should never reach here if input is valid
    }
}