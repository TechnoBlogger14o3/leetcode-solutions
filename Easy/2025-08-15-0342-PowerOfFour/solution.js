/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfFour = function(n) {
    // Handle edge cases
    if (n <= 0) return false;
    if (n === 1) return true;
    
    // Keep dividing by 4 until we can't
    while (n % 4 === 0) {
        n = Math.floor(n / 4);
    }
    
    // If we end up with 1, it's a power of 4
    return n === 1;
};

// Alternative approach using bit manipulation
var isPowerOfFour2 = function(n) {
    // A number is a power of 4 if:
    // 1. It's positive
    // 2. It's a power of 2 (only one bit set)
    // 3. The single bit is in an even position (0, 2, 4, 6, ...)
    
    return n > 0 && 
           (n & (n - 1)) === 0 &&  // Check if it's a power of 2
           (n & 0xAAAAAAAA) === 0; // Check if the bit is in even position
};

// Another approach using mathematical properties
var isPowerOfFour3 = function(n) {
    // The largest power of 4 that fits in JavaScript Number is 4^15 = 1073741824
    // So if n is a power of 4, it must divide this number
    // and also be a power of 2
    return n > 0 && 
           (n & (n - 1)) === 0 &&  // Check if it's a power of 2
           1073741824 % n === 0;   // Check if it divides the largest power of 4
};
