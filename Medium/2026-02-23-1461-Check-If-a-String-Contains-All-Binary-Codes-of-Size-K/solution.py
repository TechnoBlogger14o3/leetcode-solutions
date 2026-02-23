class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        required_count = 1 << k
        seen = set()
        
        for i in range(len(s) - k + 1):
            seen.add(s[i:i + k])
            if len(seen) == required_count:
                return True
        
        return False