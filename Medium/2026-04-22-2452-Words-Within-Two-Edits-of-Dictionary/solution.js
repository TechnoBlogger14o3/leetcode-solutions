var twoEditWords = function(queries, dictionary) {
    const isWithinTwoEdits = (word1, word2) => {
        let diffCount = 0;
        for (let i = 0; i < word1.length; i++) {
            if (word1[i] !== word2[i]) {
                diffCount++;
                if (diffCount > 2) return false;
            }
        }
        return diffCount <= 2;
    };

    const result = [];
    for (const query of queries) {
        for (const dictWord of dictionary) {
            if (isWithinTwoEdits(query, dictWord)) {
                result.push(query);
                break;
            }
        }
    }
    return result;
};