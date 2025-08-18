/**
 * @param {number[]} cards
 * @return {boolean}
 */
var judgePoint24 = function(cards) {
    // Convert to array of numbers for calculations
    let nums = cards.map(card => card);
    return backtrack(nums);
};

function backtrack(nums) {
    // Base case: if only one number left, check if it's 24
    if (nums.length === 1) {
        return Math.abs(nums[0] - 24) < 1e-6; // Use epsilon for floating point comparison
    }
    
    // Try all pairs of numbers
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            let a = nums[i];
            let b = nums[j];
            
            // Create new array without these two numbers
            let remaining = [];
            for (let k = 0; k < nums.length; k++) {
                if (k !== i && k !== j) {
                    remaining.push(nums[k]);
                }
            }
            
            // Try all possible operations
            // Addition
            remaining.push(a + b);
            if (backtrack(remaining)) return true;
            remaining.pop();
            
            // Subtraction (a - b)
            remaining.push(a - b);
            if (backtrack(remaining)) return true;
            remaining.pop();
            
            // Subtraction (b - a)
            remaining.push(b - a);
            if (backtrack(remaining)) return true;
            remaining.pop();
            
            // Multiplication
            remaining.push(a * b);
            if (backtrack(remaining)) return true;
            remaining.pop();
            
            // Division (a / b), check for division by zero
            if (Math.abs(b) > 1e-6) {
                remaining.push(a / b);
                if (backtrack(remaining)) return true;
                remaining.pop();
            }
            
            // Division (b / a), check for division by zero
            if (Math.abs(a) > 1e-6) {
                remaining.push(b / a);
                if (backtrack(remaining)) return true;
                remaining.pop();
            }
        }
    }
    
    return false;
}
