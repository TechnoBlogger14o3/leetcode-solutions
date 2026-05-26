var numSpecialEquivGroups = function(word) {
    const seen = new Set();
    
    for (let char of word) {
        const lowerChar = char.toLowerCase();
        const upperChar = char.toUpperCase();
        
        if (seen.has(lowerChar)) {
            seen.delete(lowerChar);
        } else {
            seen.add(lowerChar);
        }
        
        if (seen.has(upperChar)) {
            seen.delete(upperChar);
        } else {
            seen.add(upperChar);
        }
    }
    
    return seen.size;
};