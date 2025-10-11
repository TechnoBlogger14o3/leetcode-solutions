/**
 * Time Complexity: O(n) - Where n is total characters
 * Space Complexity: O(1) - Excluding input/output
 */
var encode = function(strs) {
    let encoded = '';
    
    for (const str of strs) {
        encoded += str.length + '#' + str;
    }
    
    return encoded;
};

var decode = function(s) {
    const decoded = [];
    let i = 0;
    
    while (i < s.length) {
        // Find the delimiter '#'
        const delimiterIndex = s.indexOf('#', i);
        
        // Extract length
        const length = parseInt(s.substring(i, delimiterIndex));
        
        // Extract string
        const str = s.substring(delimiterIndex + 1, delimiterIndex + 1 + length);
        decoded.push(str);
        
        // Move to next string
        i = delimiterIndex + 1 + length;
    }
    
    return decoded;
};

// Alternative approach using more explicit parsing
var encodeAlternative = function(strs) {
    return strs.map(str => str.length + '#' + str).join('');
};

var decodeAlternative = function(s) {
    const result = [];
    let i = 0;
    
    while (i < s.length) {
        let j = i;
        while (s[j] !== '#') {
            j++;
        }
        
        const length = parseInt(s.substring(i, j));
        const str = s.substring(j + 1, j + 1 + length);
        result.push(str);
        
        i = j + 1 + length;
    }
    
    return result;
};

// Using reduce for more functional approach
var encodeFunctional = function(strs) {
    return strs.reduce((acc, str) => acc + str.length + '#' + str, '');
};

var decodeFunctional = function(s) {
    const result = [];
    let i = 0;
    
    while (i < s.length) {
        const delimiterIndex = s.indexOf('#', i);
        const length = parseInt(s.substring(i, delimiterIndex));
        const str = s.substring(delimiterIndex + 1, delimiterIndex + 1 + length);
        result.push(str);
        i = delimiterIndex + 1 + length;
    }
    
    return result;
};
