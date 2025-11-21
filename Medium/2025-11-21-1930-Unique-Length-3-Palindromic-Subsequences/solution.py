class Solution:
    def uniquePalindromicSubseq(self, s: str) -> int:
        seen = set()
        last = {}
        for i, char in enumerate(s):
            if char in last:
                for j in last[char]:
                    seen.add(char + s[j] + char)
            if char not in last:
                last[char] = []
            last[char].append(i)
        return len(seen)

# Example test cases
sol = Solution()
print(sol.uniquePalindromicSubseq("aabca"))  # Output: 3
print(sol.uniquePalindromicSubseq("adc"))    # Output: 0
print(sol.uniquePalindromicSubseq("bbcbaba")) # Output: 4