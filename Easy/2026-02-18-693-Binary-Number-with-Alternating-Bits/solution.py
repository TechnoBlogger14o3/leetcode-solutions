class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        # Right shift n and XOR with n, then check if the result is a power of 2
        return (n ^ (n >> 1)) & ((n ^ (n >> 1)) + 1) == 0