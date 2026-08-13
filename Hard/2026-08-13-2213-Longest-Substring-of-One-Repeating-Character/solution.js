var longestRepeatingCharacterReplacement = function(s, queryCharacters, queryIndices) {
    const result = [];
    
    const getMaxLength = (str) => {
        let maxLen = 0, count = 0, prevChar = '', currentLen = 0;
        for (let char of str) {
            if (char === prevChar) {
                currentLen++;
            } else {
                maxLen = Math.max(maxLen, currentLen);
                currentLen = 1;
                prevChar = char;
            }
        }
        maxLen = Math.max(maxLen, currentLen);
        return maxLen;
    };

    for (let i = 0; i < queryCharacters.length; i++) {
        const index = queryIndices[i];
        s = s.substring(0, index) + queryCharacters[i] + s.substring(index + 1);
        result.push(getMaxLength(s));
    }

    return result;
};