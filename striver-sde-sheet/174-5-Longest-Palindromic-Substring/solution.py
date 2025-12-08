class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""
        
        start = 0
        max_len = 1
        
        def expand_around_center(left, right):
            nonlocal start, max_len
            while left >= 0 and right < len(s) and s[left] == s[right]:
                if right - left + 1 > max_len:
                    start = left
                    max_len = right - left + 1
                left -= 1
                right += 1
        
        for i in range(len(s)):
            expand_around_center(i, i)  # Odd length
            expand_around_center(i, i + 1)  # Even length
        
        return s[start:start + max_len]
