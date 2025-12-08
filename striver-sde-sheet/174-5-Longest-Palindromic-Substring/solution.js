/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    if (!s || s.length < 1) {
        return "";
    }
    
    let start = 0, maxLen = 1;
    
    function expandAroundCenter(left, right) {
        while (left >= 0 && right < s.length && s[left] === s[right]) {
            if (right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }
            left--;
            right++;
        }
    }
    
    for (let i = 0; i < s.length; i++) {
        expandAroundCenter(i, i);
        expandAroundCenter(i, i + 1);
    }
    
    return s.substring(start, start + maxLen);
};
