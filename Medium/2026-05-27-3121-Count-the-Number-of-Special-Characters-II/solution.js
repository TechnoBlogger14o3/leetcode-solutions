var countSpecialCharacters = function(word) {
    const seen = new Set();
    const special = new Set();
    
    for (let i = 0; i < word.length; i++) {
        const char = word[i];
        const lowerChar = char.toLowerCase();
        
        if (char === lowerChar) {
            if (seen.has(lowerChar)) {
                special.add(lowerChar);
            }
        } else {
            if (!seen.has(lowerChar)) {
                seen.add(lowerChar);
            } else {
                if (!special.has(lowerChar)) {
                    special.delete(lowerChar);
                }
            }
        }
    }
    
    return special.size;
};