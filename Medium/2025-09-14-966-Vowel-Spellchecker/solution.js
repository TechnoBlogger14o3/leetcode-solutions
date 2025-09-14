var spellchecker = function(wordlist, queries) {
    const wordSet = new Set(wordlist);
    const lowerCaseMap = new Map();
    const vowelMap = new Map();
    const vowels = 'aeiou';

    for (const word of wordlist) {
        const lowerWord = word.toLowerCase();
        if (!lowerCaseMap.has(lowerWord)) {
            lowerCaseMap.set(lowerWord, word);
        }
        const vowelKey = lowerWord.replace(/[aeiou]/g, '*');
        if (!vowelMap.has(vowelKey)) {
            vowelMap.set(vowelKey, word);
        }
    }

    const result = [];
    for (const query of queries) {
        if (wordSet.has(query)) {
            result.push(query);
        } else {
            const lowerQuery = query.toLowerCase();
            if (lowerCaseMap.has(lowerQuery)) {
                result.push(lowerCaseMap.get(lowerQuery));
            } else {
                const vowelKey = lowerQuery.replace(/[aeiou]/g, '*');
                if (vowelMap.has(vowelKey)) {
                    result.push(vowelMap.get(vowelKey));
                } else {
                    result.push('');
                }
            }
        }
    }

    return result;
};