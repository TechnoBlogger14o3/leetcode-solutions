/**
 * Time Complexity: O(n) - Where n is length of s2
 * Space Complexity: O(1) - At most 26 characters
 */
var checkInclusion = function(s1, s2) {
    if (s1.length > s2.length) return false;
    
    const s1Count = new Array(26).fill(0);
    const s2Count = new Array(26).fill(0);
    
    // Initialize frequency maps
    for (let i = 0; i < s1.length; i++) {
        s1Count[s1.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        s2Count[s2.charCodeAt(i) - 'a'.charCodeAt(0)]++;
    }
    
    // Check if initial window matches
    if (arraysEqual(s1Count, s2Count)) return true;
    
    // Slide window
    for (let i = s1.length; i < s2.length; i++) {
        // Remove leftmost character
        s2Count[s2.charCodeAt(i - s1.length) - 'a'.charCodeAt(0)]--;
        
        // Add rightmost character
        s2Count[s2.charCodeAt(i) - 'a'.charCodeAt(0)]++;
        
        // Check if frequencies match
        if (arraysEqual(s1Count, s2Count)) return true;
    }
    
    return false;
};

// Helper function to compare arrays
function arraysEqual(arr1, arr2) {
    return arr1.length === arr2.length && arr1.every((val, i) => val === arr2[i]);
}

// Alternative approach using Map
var checkInclusionMap = function(s1, s2) {
    if (s1.length > s2.length) return false;
    
    const s1Count = {};
    const s2Count = {};
    
    // Initialize s1 frequency map
    for (const c of s1) {
        s1Count[c] = (s1Count[c] || 0) + 1;
    }
    
    // Initialize window
    for (let i = 0; i < s1.length; i++) {
        const c = s2[i];
        s2Count[c] = (s2Count[c] || 0) + 1;
    }
    
    if (mapsEqual(s1Count, s2Count)) return true;
    
    // Slide window
    for (let i = s1.length; i < s2.length; i++) {
        // Remove leftmost character
        const leftChar = s2[i - s1.length];
        s2Count[leftChar]--;
        if (s2Count[leftChar] === 0) {
            delete s2Count[leftChar];
        }
        
        // Add rightmost character
        const rightChar = s2[i];
        s2Count[rightChar] = (s2Count[rightChar] || 0) + 1;
        
        if (mapsEqual(s1Count, s2Count)) return true;
    }
    
    return false;
};

// Helper function to compare maps
function mapsEqual(map1, map2) {
    const keys1 = Object.keys(map1);
    const keys2 = Object.keys(map2);
    
    if (keys1.length !== keys2.length) return false;
    
    return keys1.every(key => map1[key] === map2[key]);
};

// More concise version
var checkInclusionConcise = function(s1, s2) {
    if (s1.length > s2.length) return false;
    
    const count = new Array(26).fill(0);
    for (const c of s1) count[c.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    
    let left = 0;
    for (let right = 0; right < s2.length; right++) {
        count[s2.charCodeAt(right) - 'a'.charCodeAt(0)]--;
        
        if (right - left + 1 === s1.length) {
            if (count.every(x => x === 0)) return true;
            count[s2.charCodeAt(left) - 'a'.charCodeAt(0)]++;
            left++;
        }
    }
    
    return false;
};
