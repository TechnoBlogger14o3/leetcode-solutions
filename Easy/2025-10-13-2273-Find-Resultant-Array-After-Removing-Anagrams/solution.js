var removeAnagrams = function(words) {
    const result = [];
    let prevSorted = '';

    for (const word of words) {
        const sortedWord = word.split('').sort().join('');
        if (sortedWord !== prevSorted) {
            result.push(word);
            prevSorted = sortedWord;
        }
    }

    return result;
};