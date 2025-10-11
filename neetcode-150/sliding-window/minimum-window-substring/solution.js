/**
 * Time Complexity: O(m + n) - Where m is length of s, n is length of t
 * Space Complexity: O(m + n) - For frequency maps
 */
var minWindow = function(s, t) {
    if (s.length < t.length) return "";
    
    const tCount = {};
    for (const c of t) {
        tCount[c] = (tCount[c] || 0) + 1;
    }
    
    let left = 0;
    let minStart = 0;
    let minLen = Infinity;
    let counter = t.length;
    
    for (let right = 0; right < s.length; right++) {
        const rightChar = s[right];
        
        if (tCount[rightChar] !== undefined) {
            tCount[rightChar]--;
            if (tCount[rightChar] >= 0) {
                counter--;
            }
        }
        
        while (counter === 0) {
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                minStart = left;
            }
            
            const leftChar = s[left];
            if (tCount[leftChar] !== undefined) {
                tCount[leftChar]++;
                if (tCount[leftChar] > 0) {
                    counter++;
                }
            }
            left++;
        }
    }
    
    return minLen === Infinity ? "" : s.substring(minStart, minStart + minLen);
};

// Alternative approach using arrays for ASCII characters
var minWindowArray = function(s, t) {
    if (s.length < t.length) return "";
    
    const tCount = new Array(128).fill(0);
    for (const c of t) {
        tCount[c.charCodeAt(0)]++;
    }
    
    let left = 0;
    let minStart = 0;
    let minLen = Infinity;
    let counter = t.length;
    
    for (let right = 0; right < s.length; right++) {
        const rightChar = s[right];
        
        if (tCount[rightChar.charCodeAt(0)] > 0) {
            counter--;
        }
        tCount[rightChar.charCodeAt(0)]--;
        
        while (counter === 0) {
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                minStart = left;
            }
            
            const leftChar = s[left];
            tCount[leftChar.charCodeAt(0)]++;
            if (tCount[leftChar.charCodeAt(0)] > 0) {
                counter++;
            }
            left++;
        }
    }
    
    return minLen === Infinity ? "" : s.substring(minStart, minStart + minLen);
};

// More concise version
var minWindowConcise = function(s, t) {
    const map = new Array(128).fill(0);
    for (const c of t) map[c.charCodeAt(0)]++;
    
    let left = 0, minStart = 0, minLen = Infinity, counter = t.length;
    
    for (let right = 0; right < s.length; right++) {
        if (map[s[right].charCodeAt(0)]-- > 0) counter--;
        
        while (counter === 0) {
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                minStart = left;
            }
            if (map[s[left++].charCodeAt(0)]++ === 0) counter++;
        }
    }
    
    return minLen === Infinity ? "" : s.substring(minStart, minStart + minLen);
};
