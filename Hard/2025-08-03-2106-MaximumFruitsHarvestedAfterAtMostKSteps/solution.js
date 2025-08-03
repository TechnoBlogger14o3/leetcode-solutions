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
    let left = 0;
    let currentSum = 0;
    
    // Sliding window approach
    for (let right = 0; right < n; right++) {
        currentSum += fruits[right][1];
        
        // Shrink window from left while it's invalid
        while (left <= right) {
            const leftPos = fruits[left][0];
            const rightPos = fruits[right][0];
            
            // Calculate minimum steps needed for current window
            const steps = rightPos - leftPos + Math.min(Math.abs(startPos - leftPos), Math.abs(startPos - rightPos));
            
            if (steps <= k) {
                break; // Window is valid, keep it
            }
            
            // Remove leftmost fruit and shrink window
            currentSum -= fruits[left][1];
            left++;
        }
        
        // Update max fruits if window is valid
        if (left <= right) {
            maxFruits = Math.max(maxFruits, currentSum);
        }
    }
    
    return maxFruits;
}; 