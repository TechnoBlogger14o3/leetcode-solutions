class Solution:
    def totalMoney(self, n: int) -> int:
        weeks = n // 7
        extra_days = n % 7
        total = (weeks * (7 * (weeks + 1) // 2)) + (extra_days * (extra_days + 1) // 2) + (weeks * extra_days)
        return total