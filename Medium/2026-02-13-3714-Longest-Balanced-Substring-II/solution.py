class Solution:
    def longestBalancedSubstring(self, s: str) -> int:
        max_length = 0
        n = len(s)

        for i in range(n):
            count = {}
            for j in range(i, n):
                count[s[j]] = count.get(s[j], 0) + 1
                if len(count) > 3:
                    break
                if len(count) == 1:
                    continue
                if len(count) == 2:
                    if len(set(count.values())) == 1:
                        max_length = max(max_length, j - i + 1)
                elif len(count) == 3:
                    if len(set(count.values())) == 1:
                        max_length = max(max_length, j - i + 1)

        return max_length