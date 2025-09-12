var vowelsGame = function(s) {
    const vowels = new Set(['a', 'e', 'i', 'o', 'u']);
    let countVowels = 0;

    for (let char of s) {
        if (vowels.has(char)) {
            countVowels++;
        }
    }

    return countVowels % 2 === 1;
};