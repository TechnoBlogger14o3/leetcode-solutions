class Solution:
    def minFlips(self, s: str) -> int:
        n = len(s)
        s = s + s  # Concatenate the string to handle rotations
        count1 = count2 = 0
        
        # Count flips for the two possible alternating patterns
        for i in range(n):
            if s[i] != '0' if i % 2 == 0 else '1':
                count1 += 1
            if s[i] != '1' if i % 2 == 0 else '0':
                count2 += 1
        
        # Minimum flips needed for any rotation
        min_flips = min(count1, count2)
        
        for i in range(n, len(s)):
            if s[i] != '0' if i % 2 == 0 else '1':
                count1 += 1
            if s[i] != '1' if i % 2 == 0 else '0':
                count2 += 1
            
            if s[i - n] != '0' if (i - n) % 2 == 0 else '1':
                count1 -= 1
            if s[i - n] != '1' if (i - n) % 2 == 0 else '0':
                count2 -= 1
            
            min_flips = min(min_flips, count1, count2)
        
        return min_flips