var maxPalindromes = function(s, k) {
    const n = s.length;
    const dp = new Array(n + 1).fill(0);
    const isPalindrome = new Array(n).fill(0).map(() => new Array(n).fill(false));

    // Precompute all palindromic substrings
    for (let len = 1; len <= n; len++) {
        for (let i = 0; i <= n - len; i++) {
            const j = i + len - 1;
            if (len === 1) {
                isPalindrome[i][j] = true;
            } else if (len === 2) {
                isPalindrome[i][j] = s[i] === s[j];
            } else {
                isPalindrome[i][j] = s[i] === s[j] && isPalindrome[i + 1][j - 1];
            }
        }
    }

    // Dynamic programming to find the maximum number of non-overlapping palindromic substrings
    for (let i = 0; i < n; i++) {
        dp[i + 1] = dp[i]; // carry forward the previous value
        for (let j = i; j >= 0; j--) {
            if (i - j + 1 >= k && isPalindrome[j][i]) {
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + 1);
            }
        }
    }

    return dp[n];
};