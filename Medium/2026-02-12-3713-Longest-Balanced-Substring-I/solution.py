class Solution:
    def longestBalancedSubstring(self, s: str) -> int:
        max_length = 0
        n = len(s)

        for length in range(1, n + 1):
            count = {}
            for i in range(n):
                if i + length <= n:
                    substring = s[i:i + length]
                    count.clear()
                    for char in substring:
                        count[char] = count.get(char, 0) + 1
                    
                    if len(set(count.values())) == 1:
                        max_length = max(max_length, length)

        return max_length