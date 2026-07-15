import math

class Solution:
    def findGCD(self, n: int) -> int:
        sumOdd = n * n
        sumEven = n * (n + 1)
        return math.gcd(sumOdd, sumEven)