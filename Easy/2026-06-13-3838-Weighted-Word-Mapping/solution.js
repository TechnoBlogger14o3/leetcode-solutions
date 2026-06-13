var weightedWordMapping = function(words, weights) {
    const mapWeightToChar = (weight) => String.fromCharCode('z'.charCodeAt(0) - weight);
    
    return words.map(word => {
        let totalWeight = 0;
        for (const char of word) {
            totalWeight += weights[char.charCodeAt(0) - 'a'.charCodeAt(0)];
        }
        return mapWeightToChar(totalWeight % 26);
    }).join('');
};