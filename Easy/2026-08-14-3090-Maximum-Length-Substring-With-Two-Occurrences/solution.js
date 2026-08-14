var maximumLengthSubstring = function(s) {
    let left = 0, right = 0;
    let maxLength = 0;
    const charCount = {};

    while (right < s.length) {
        charCount[s[right]] = (charCount[s[right]] || 0) + 1;

        while (charCount[s[right]] > 2) {
            charCount[s[left]]--;
            if (charCount[s[left]] === 0) {
                delete charCount[s[left]];
            }
            left++;
        }

        maxLength = Math.max(maxLength, right - left + 1);
        right++;
    }

    return maxLength;
};