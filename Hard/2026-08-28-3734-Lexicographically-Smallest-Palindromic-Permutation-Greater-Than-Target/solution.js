var getLexicographicallySmallestPalindromicPermutation = function(s, target) {
    const charCount = Array(26).fill(0);
    for (const char of s) {
        charCount[char.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }

    let oddCount = 0;
    let half = '';
    let oddChar = '';

    for (let i = 0; i < 26; i++) {
        if (charCount[i] % 2 === 1) {
            oddCount++;
            oddChar = String.fromCharCode(i + 'a'.charCodeAt(0));
        }
        half += String.fromCharCode(i + 'a'.charCodeAt(0)).repeat(Math.floor(charCount[i] / 2));
    }

    if (oddCount > 1) return '';

    const palindromic = half + oddChar + half.split('').reverse().join('');
    if (palindromic <= target) {
        const nextPalindromic = getNextPalindromic(half, oddChar);
        return nextPalindromic > target ? nextPalindromic : '';
    }
    return palindromic > target ? palindromic : '';
};

function getNextPalindromic(half, oddChar) {
    const arr = half.split('');
    let i = arr.length - 1;

    while (i >= 0 && arr[i] === 'z') {
        arr[i] = 'a';
        i--;
    }

    if (i < 0) return '';

    arr[i] = String.fromCharCode(arr[i].charCodeAt(0) + 1);
    const newHalf = arr.join('');
    return newHalf + oddChar + newHalf.split('').reverse().join('');
}

// Example usage
console.log(getLexicographicallySmallestPalindromicPermutation("baba", "abba")); // "baab"
console.log(getLexicographicallySmallestPalindromicPermutation("baba", "bbaa")); // ""
console.log(getLexicographicallySmallestPalindromicPermutation("abc", "abb")); // ""
console.log(getLexicographicallySmallestPalindromicPermutation("aac", "abb")); // "aca"