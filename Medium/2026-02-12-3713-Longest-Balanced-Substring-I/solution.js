var longestBalancedSubstring = function(s) {
    let maxLength = 0;

    for (let len = 1; len <= s.length; len++) {
        for (let start = 0; start <= s.length - len; start++) {
            const substring = s.substring(start, start + len);
            const charCount = {};
            for (const char of substring) {
                charCount[char] = (charCount[char] || 0) + 1;
            }
            const counts = Object.values(charCount);
            if (new Set(counts).size === 1) {
                maxLength = Math.max(maxLength, len);
            }
        }
    }

    return maxLength;
};