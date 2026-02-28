class Solution:
    def concatenatedBinary(self, n: int) -> int:
        mod = 10**9 + 7
        result = 0
        length = 0
        
        for i in range(1, n + 1):
            if (i & (i - 1)) == 0:  # Check if i is a power of 2
                length += 1
            result = ((result << length) | i) % mod
        
        return result