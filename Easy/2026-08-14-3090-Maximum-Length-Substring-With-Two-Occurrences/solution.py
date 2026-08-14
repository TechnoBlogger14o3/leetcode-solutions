class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        left = 0
        count = {}
        max_length = 0
        
        for right in range(len(s)):
            count[s[right]] = count.get(s[right], 0) + 1
            
            while any(v > 2 for v in count.values()):
                count[s[left]] -= 1
                if count[s[left]] == 0:
                    del count[s[left]]
                left += 1
            
            max_length = max(max_length, right - left + 1)
        
        return max_length