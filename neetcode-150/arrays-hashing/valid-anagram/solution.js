/**
 * Time Complexity: O(n) - Where n is the length of the strings
 * Space Complexity: O(1) - At most 26 characters for lowercase English letters
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }
    
    const charCount = {};
    
    // Count characters in string s
    for (const char of s) {
        charCount[char] = (charCount[char] || 0) + 1;
    }
    
    // Check characters in string t
    for (const char of t) {
        if (!charCount[char] || charCount[char] === 0) {
            return false;
        }
        charCount[char]--;
    }
    
    return true;
};

// Alternative approach using array (more efficient for lowercase letters)
var isAnagramArray = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }
    
    const charCount = new Array(26).fill(0);
    
    for (let i = 0; i < s.length; i++) {
        charCount[s.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        charCount[t.charCodeAt(i) - 'a'.charCodeAt(0)]--;
    }
    
    return charCount.every(count => count === 0);
};

// Sorting approach
var isAnagramSorting = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }
    
    const sSorted = s.split('').sort().join('');
    const tSorted = t.split('').sort().join('');
    
    return sSorted === tSorted;
};
