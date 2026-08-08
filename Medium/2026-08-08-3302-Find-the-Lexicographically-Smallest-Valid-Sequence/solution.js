var findTheLexicographicallySmallestValidSequence = function(word1, word2) {
    const n = word1.length;
    const m = word2.length;
    const result = [];
    
    let j = 0;
    for (let i = 0; i < n && j < m; i++) {
        if (word1[i] === word2[j]) {
            result.push(i);
            j++;
        } else if (j < m - 1 && word1[i] === word2[j + 1]) {
            result.push(i);
            j++;
        }
    }
    
    if (result.length !== m) return [];
    
    let changes = 0;
    for (let i = 0; i < m; i++) {
        if (word1[result[i]] !== word2[i]) {
            changes++;
        }
    }
    
    return changes <= 1 ? result : [];
};