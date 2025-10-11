/**
 * Time Complexity: O(n) - Single pass through the string
 * Space Complexity: O(1) - At most 26 characters
 */
var characterReplacement = function(s, k) {
    let left = 0;
    let maxLength = 0;
    let maxCount = 0;
    const charCount = {};
    
    for (let right = 0; right < s.length; right++) {
        const rightChar = s[right];
        charCount[rightChar] = (charCount[rightChar] || 0) + 1;
        
        // Update maxCount to track most frequent character
        maxCount = Math.max(maxCount, charCount[rightChar]);
        
        // If window size - maxCount > k, contract window
        if (right - left + 1 - maxCount > k) {
            const leftChar = s[left];
            charCount[leftChar]--;
            left++;
        }
        
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
};

// Alternative approach using array for ASCII characters
var characterReplacementArray = function(s, k) {
    const charCount = new Array(26).fill(0);
    let left = 0, maxCount = 0, maxLength = 0;
    
    for (let right = 0; right < s.length; right++) {
        const rightChar = s[right];
        charCount[rightChar.charCodeAt(0) - 'A'.charCodeAt(0)]++;
        
        maxCount = Math.max(maxCount, charCount[rightChar.charCodeAt(0) - 'A'.charCodeAt(0)]);
        
        if (right - left + 1 - maxCount > k) {
            const leftChar = s[left];
            charCount[leftChar.charCodeAt(0) - 'A'.charCodeAt(0)]--;
            left++;
        }
        
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
};

// More concise version
var characterReplacementConcise = function(s, k) {
    const count = new Array(26).fill(0);
    let left = 0, maxCount = 0, maxLength = 0;
    
    for (let right = 0; right < s.length; right++) {
        maxCount = Math.max(maxCount, ++count[s[right].charCodeAt(0) - 'A'.charCodeAt(0)]);
        
        if (right - left + 1 - maxCount > k) {
            count[s[left++].charCodeAt(0) - 'A'.charCodeAt(0)]--;
        }
        
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
};
