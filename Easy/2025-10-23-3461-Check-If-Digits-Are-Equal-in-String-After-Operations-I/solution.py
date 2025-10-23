class Solution:
    def digitsAverage(self, s: str) -> bool:
        while len(s) > 2:
            s = ''.join(str((int(s[i]) + int(s[i + 1])) % 10) for i in range(len(s) - 1))
        return s[0] == s[1]

# Example usage:
# sol = Solution()
# print(sol.digitsAverage("3902"))  # Output: True
# print(sol.digitsAverage("34789"))  # Output: False