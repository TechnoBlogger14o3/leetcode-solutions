class Solution:
    def smallestGoodBase(self, n: int) -> str:
        max_base = int(n**0.5) + 1
        for base in range(max_base, 1, -1):
            x = 1
            total = 1
            while total < n:
                x *= base
                total += x
            if total == n:
                return str(base)
        return str(n - 1)

    def smallestNumber(self, n: int) -> int:
        if n == 1:
            return 1
        return (1 << (n - 1).bit_length()) - 1