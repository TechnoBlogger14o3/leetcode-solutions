class Solution:
    def checkEqualString(self, s1: str, s2: str) -> bool:
        if sorted(s1) != sorted(s2):
            return False
        
        # Check pairs of indices (0, 2) and (1, 3)
        return (s1[0], s1[2]) == (s2[0], s2[2]) and (s1[1], s1[3]) == (s2[1], s2[3]) or \
               (s1[0], s1[2]) == (s2[1], s2[3]) and (s1[1], s1[3]) == (s2[0], s2[2])

# Example usage:
# sol = Solution()
# print(sol.checkEqualString("abcd", "cdab"))  # Output: True
# print(sol.checkEqualString("abcd", "dacb"))  # Output: False