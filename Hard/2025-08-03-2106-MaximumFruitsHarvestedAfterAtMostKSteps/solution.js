/**
 * @param {number[][]} fruits
 * @param {number} startPos
 * @param {number} k
 * @return {number}
 */
var maxTotalFruits = function(fruits, startPos, k) {
    // Sort fruits by position
    fruits.sort((a, b) => a[0] - b[0]);
    
    const n = fruits.length;
    let maxFruits = 0;
    
    // Try all possible ranges
    for (let left = 0; left < n; left++) {
        for (let right = left; right < n; right++) {
            const leftPos = fruits[left][0];
            const rightPos = fruits[right][0];
            
            // Calculate minimum steps needed
            const steps = rightPos - leftPos + Math.min(Math.abs(startPos - leftPos), Math.abs(startPos - rightPos));
            
            if (steps <= k) {
                // Calculate total fruits in this range
                let totalFruits = 0;
                for (let i = left; i <= right; i++) {
                    totalFruits += fruits[i][1];
                }
                maxFruits = Math.max(maxFruits, totalFruits);
            }
        }
    }
    
    return maxFruits;
}; 