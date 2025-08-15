/**
 * @param {string} num
 * @return {string}
 */
var largestGoodInteger = function(num) {
    let result = "";
    
    // Check for 3 consecutive same digits starting from the left
    for (let i = 0; i <= num.length - 3; i++) {
        // Check if current position and next two positions have the same digit
        if (num[i] === num[i + 1] && num[i + 1] === num[i + 2]) {
            
            const current = num.substring(i, i + 3);
            
            // Update result if current is larger (lexicographically)
            if (current > result) {
                result = current;
            }
        }
    }
    
    return result;
};

// Alternative approach using sliding window
var largestGoodInteger2 = function(num) {
    let result = "";
    
    // Use sliding window of size 3
    for (let i = 0; i <= num.length - 3; i++) {
        const c1 = num[i];
        const c2 = num[i + 1];
        const c3 = num[i + 2];
        
        // Check if all three characters are the same
        if (c1 === c2 && c2 === c3) {
            const current = c1 + c2 + c3;
            
            // Update result if current is larger
            if (result === "" || current > result) {
                result = current;
            }
        }
    }
    
    return result;
};

