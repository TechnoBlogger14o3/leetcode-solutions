class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        n = len(s)
        if s[n - 1] != '0':
            return False
        
        reachable = 0
        for i in range(n):
            if i > reachable:
                return False
            if s[i] == '0':
                if i + minJump <= n - 1:
                    reachable = max(reachable, i + maxJump)
        
        return reachable >= n - 1