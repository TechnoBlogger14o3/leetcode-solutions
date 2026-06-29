var countSubstrings = function(patterns, word) {
    let count = 0;
    for (let pattern of patterns) {
        if (word.includes(pattern)) {
            count++;
        }
    }
    return count;
};