class Solution:
    def minimumChanges(self, s: str) -> int:
        changes = 0
        n = len(s)
        
        for i in range(0, n, 2):
            if s[i] != s[i + 1]:
                changes += 1
        
        return changes