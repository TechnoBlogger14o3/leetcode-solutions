/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    if (!strs || strs.length === 0) {
        return "";
    }
    
    // Find the shortest string
    let shortest = strs.reduce((a, b) => a.length <= b.length ? a : b);
    
    // Check each character of the shortest string
    for (let i = 0; i < shortest.length; i++) {
        const char = shortest[i];
        // Check if all strings have the same character at position i
        for (let str of strs) {
            if (str[i] !== char) {
                return shortest.substring(0, i);
            }
        }
    }
    
    return shortest;
};

