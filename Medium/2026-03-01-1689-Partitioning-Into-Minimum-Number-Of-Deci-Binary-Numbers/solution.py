class Solution:
    def minPartitions(self, n: str) -> int:
        return max(int(digit) for digit in n)