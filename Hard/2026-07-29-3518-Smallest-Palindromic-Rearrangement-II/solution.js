class Solution {
    getKthPalindrome(s, k) {
        const count = {};
        for (const char of s) {
            count[char] = (count[char] || 0) + 1;
        }

        const half = [];
        let oddChar = '';
        for (const [char, freq] of Object.entries(count)) {
            if (freq % 2 === 1) {
                if (oddChar) return ""; // More than one odd character
                oddChar = char;
            }
            half.push(char.repeat(Math.floor(freq / 2)));
        }

        half.sort();
        const halfStr = half.join('');
        const palindromes = new Set();
        const generatePalindromes = (current, remaining) => {
            if (remaining.length === 0) {
                const palindrome = current + (oddChar ? oddChar : '') + current.split('').reverse().join('');
                palindromes.add(palindrome);
                return;
            }
            const used = new Set();
            for (let i = 0; i < remaining.length; i++) {
                if (used.has(remaining[i])) continue;
                used.add(remaining[i]);
                generatePalindromes(current + remaining[i], remaining.slice(0, i) + remaining.slice(i + 1));
            }
        };

        generatePalindromes('', halfStr);
        const sortedPalindromes = Array.from(palindromes).sort();
        return sortedPalindromes[k - 1] || '';
    }
}