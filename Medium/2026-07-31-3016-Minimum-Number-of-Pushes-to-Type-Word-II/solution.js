var minimumPushes = function(word) {
    const frequency = new Array(26).fill(0);
    
    for (const char of word) {
        frequency[char.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }
    
    frequency.sort((a, b) => b - a);
    
    let pushes = 0;
    for (let i = 0; i < frequency.length; i++) {
        if (frequency[i] === 0) break;
        pushes += frequency[i] * Math.ceil((i + 1) / 3);
    }
    
    return pushes;
};