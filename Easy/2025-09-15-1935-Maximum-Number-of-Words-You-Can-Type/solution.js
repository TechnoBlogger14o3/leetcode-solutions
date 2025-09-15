var canBeTypedWords = function(text, brokenLetters) {
    const brokenSet = new Set(brokenLetters);
    const words = text.split(' ');
    let count = 0;

    for (const word of words) {
        if (![...word].some(char => brokenSet.has(char))) {
            count++;
        }
    }

    return count;
};