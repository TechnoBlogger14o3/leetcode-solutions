class Solution:
    def concatenateNonZeroDigitsAndMultiply(self, n: int) -> int:
        digits = [int(d) for d in str(n) if d != '0']
        if not digits:
            return 0
        x = int(''.join(map(str, digits)))
        sum_digits = sum(digits)
        return x * sum_digits