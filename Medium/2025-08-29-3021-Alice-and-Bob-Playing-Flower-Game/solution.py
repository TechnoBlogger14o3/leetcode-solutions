python
class Solution:
    def countPairs(self, n: int, m: int) -> int:
        count = 0
        for x in range(1, n + 1):
            for y in range(1, m + 1):
                if (x + y) % 2 == 1:
                    count += 1
        return count