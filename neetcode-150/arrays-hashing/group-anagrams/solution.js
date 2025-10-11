/**
 * Time Complexity: O(n * m log m) - Where n is number of strings, m is average length
 * Space Complexity: O(n * m) - For storing all strings
 */
var groupAnagrams = function(strs) {
    const anagramGroups = {};
    
    for (const str of strs) {
        // Sort characters to create key
        const key = str.split('').sort().join('');
        
        // Add to appropriate group
        if (!anagramGroups[key]) {
            anagramGroups[key] = [];
        }
        anagramGroups[key].push(str);
    }
    
    return Object.values(anagramGroups);
};

// Alternative approach using character frequency count
var groupAnagramsFrequency = function(strs) {
    const anagramGroups = {};
    
    for (const str of strs) {
        // Create frequency count key
        const count = new Array(26).fill(0);
        for (const char of str) {
            count[char.charCodeAt(0) - 'a'.charCodeAt(0)]++;
        }
        
        // Convert count array to string key
        const key = count.map(c => `#${c}`).join('');
        
        // Add to appropriate group
        if (!anagramGroups[key]) {
            anagramGroups[key] = [];
        }
        anagramGroups[key].push(str);
    }
    
    return Object.values(anagramGroups);
};

// More concise version
var groupAnagramsConcise = function(strs) {
    const groups = {};
    
    strs.forEach(str => {
        const key = str.split('').sort().join('');
        groups[key] = groups[key] || [];
        groups[key].push(str);
    });
    
    return Object.values(groups);
};
