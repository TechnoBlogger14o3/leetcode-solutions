/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfThree = function(n) {
    // Handle edge cases
    if (n <= 0) return false;
    if (n === 1) return true;
    
    // Keep dividing by 3 until we can't
    while (n % 3 === 0) {
        n = Math.floor(n / 3);
    }
    
    // If we end up with 1, it's a power of 3
    return n === 1;
};

// Alternative approach using mathematical properties
var isPowerOfThree2 = function(n) {
    // The largest power of 3 that fits in JavaScript Number is 3^19 = 1162261467
    // So if n is a power of 3, it must divide this number
    return n > 0 && 1162261467 % n === 0;
};


