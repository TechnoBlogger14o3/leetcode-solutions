class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        groups = [1]
        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                groups[-1] += 1
            else:
                groups.append(1)
        
        count = 0
        for i in range(1, len(groups)):
            count += min(groups[i - 1], groups[i])
        
        return count