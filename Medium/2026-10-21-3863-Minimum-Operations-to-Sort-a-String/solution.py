class Solution:
    def minimumOperations(self, s: str) -> int:
        n = len(s)
        sorted_s = ''.join(sorted(s))
        
        if s == sorted_s:
            return 0
        
        # Count the number of segments that are already in order
        segments = 0
        i = 0
        
        while i < n:
            if s[i] == sorted_s[i]:
                segments += 1
                while i < n and s[i] == sorted_s[i]:
                    i += 1
            else:
                i += 1
        
        # If segments are equal to the length of the string, it means we can't sort it
        if segments == n:
            return -1
        
        return max(1, segments)