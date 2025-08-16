/**
 * @param {number} num
 * @return {number}
 */
var maximum69Number = function(num) {
    // Convert to string to easily manipulate digits
    let numStr = num.toString();
    let digits = numStr.split('');
    
    // Find the first occurrence of '6' and change it to '9'
    for (let i = 0; i < digits.length; i++) {
        if (digits[i] === '6') {
            digits[i] = '9';
            break; // Only change the first occurrence
        }
    }
    
    // Convert back to integer
    return parseInt(digits.join(''));
};
