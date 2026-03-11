class Solution:
    def findComplement(self, n: int) -> int:
        mask = 1
        while mask <= n:
            mask <<= 1
        return (mask - 1) ^ n