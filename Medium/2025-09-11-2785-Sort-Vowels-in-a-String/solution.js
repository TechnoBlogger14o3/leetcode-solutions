var sortVowels = function(s) {
    const vowels = 'aeiouAEIOU';
    const vowelChars = [];
    const result = s.split('');

    for (let char of s) {
        if (vowels.includes(char)) {
            vowelChars.push(char);
        }
    }

    vowelChars.sort((a, b) => a.localeCompare(b));

    let vowelIndex = 0;
    for (let i = 0; i < result.length; i++) {
        if (vowels.includes(result[i])) {
            result[i] = vowelChars[vowelIndex++];
        }
    }

    return result.join('');
};