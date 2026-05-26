class Solution:
    def numSpecialEquivGroups(self, word: str) -> int:
        lower_set = set()
        upper_set = set()
        
        for char in word:
            if char.islower():
                lower_set.add(char)
            else:
                upper_set.add(char.lower())
        
        return len(lower_set.intersection(upper_set))

# Example usage:
# sol = Solution()
# print(sol.numSpecialEquivGroups("aaAbcBC"))  # Output: 3
# print(sol.numSpecialEquivGroups("abc"))      # Output: 0
# print(sol.numSpecialEquivGroups("abBCab"))   # Output: 1