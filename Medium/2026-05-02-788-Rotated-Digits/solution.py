class Solution:
    def rotatedDigits(self, n: int) -> int:
        good_count = 0
        for i in range(1, n + 1):
            s = str(i)
            if all(c in '0125689' for c in s) and any(c in '2569' for c in s):
                good_count += 1
        return good_count