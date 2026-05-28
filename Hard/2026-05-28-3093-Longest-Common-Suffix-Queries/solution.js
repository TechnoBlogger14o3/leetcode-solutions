class SuffixArray {
    constructor(words) {
        this.words = words;
    }

    longestCommonSuffix(query) {
        let maxLength = 0;
        let minLength = Infinity;
        let bestIndex = -1;

        for (let i = 0; i < this.words.length; i++) {
            const word = this.words[i];
            let j = 0;
            while (j < word.length && j < query.length && word[word.length - 1 - j] === query[query.length - 1 - j]) {
                j++;
            }
            if (j > maxLength || (j === maxLength && word.length < minLength)) {
                maxLength = j;
                minLength = word.length;
                bestIndex = i;
            }
        }

        return bestIndex;
    }
}

var longestCommonSuffixQueries = function(wordsContainer, wordsQuery) {
    const suffixArray = new SuffixArray(wordsContainer);
    return wordsQuery.map(query => suffixArray.longestCommonSuffix(query));
};