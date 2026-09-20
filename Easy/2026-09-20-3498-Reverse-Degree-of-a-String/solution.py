class Solution:
    def reverseDegree(self, s: str) -> int:
        total = 0
        for i, char in enumerate(s):
            position_in_reversed_alphabet = 26 - (ord(char) - ord('a'))
            total += position_in_reversed_alphabet * (i + 1)
        return total