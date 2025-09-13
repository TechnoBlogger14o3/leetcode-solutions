var maxVowelsAndConsonants = function(s) {
    const vowelSet = new Set(['a', 'e', 'i', 'o', 'u']);
    const frequency = {};
    
    for (const char of s) {
        frequency[char] = (frequency[char] || 0) + 1;
    }
    
    let maxVowelFreq = 0;
    let maxConsonantFreq = 0;
    
    for (const char in frequency) {
        if (vowelSet.has(char)) {
            maxVowelFreq = Math.max(maxVowelFreq, frequency[char]);
        } else {
            maxConsonantFreq = Math.max(maxConsonantFreq, frequency[char]);
        }
    }
    
    return maxVowelFreq + maxConsonantFreq;
};