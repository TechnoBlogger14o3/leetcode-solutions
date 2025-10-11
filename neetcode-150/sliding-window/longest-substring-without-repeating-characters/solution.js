/**
 * Time Complexity: O(n) - Each character visited at most twice
 * Space Complexity: O(min(m,n)) - Where m is charset size
 */
var lengthOfLongestSubstring = function(s) {
    if (s.length === 0) return 0;
    
    const charCount = {};
    let left = 0;
    let maxLength = 0;
    
    for (let right = 0; right < s.length; right++) {
        const rightChar = s[right];
        charCount[rightChar] = (charCount[rightChar] || 0) + 1;
        
        // Contract window if duplicates found
        while (charCount[rightChar] > 1) {
            const leftChar = s[left];
            charCount[leftChar]--;
            left++;
        }
        
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
};

// Alternative approach using Set
var lengthOfLongestSubstringSet = function(s) {
    if (s.length === 0) return 0;
    
    const charSet = new Set();
    let left = 0;
    let maxLength = 0;
    
    for (let right = 0; right < s.length; right++) {
        const rightChar = s[right];
        
        // Contract window if duplicate found
        while (charSet.has(rightChar)) {
            charSet.delete(s[left]);
            left++;
        }
        
        charSet.add(rightChar);
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
};

// Optimized version with character position tracking
var lengthOfLongestSubstringOptimized = function(s) {
    const charIndex = {};
    let left = 0;
    let maxLength = 0;
    
    for (let right = 0; right < s.length; right++) {
        const rightChar = s[right];
        
        if (charIndex[rightChar] !== undefined && charIndex[rightChar] >= left) {
            left = charIndex[rightChar] + 1;
        }
        
        charIndex[rightChar] = right;
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
};

// More concise version
var lengthOfLongestSubstringConcise = function(s) {
    const seen = new Set();
    let left = 0, maxLength = 0;
    
    for (let right = 0; right < s.length; right++) {
        while (seen.has(s[right])) {
            seen.delete(s[left++]);
        }
        seen.add(s[right]);
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
};
