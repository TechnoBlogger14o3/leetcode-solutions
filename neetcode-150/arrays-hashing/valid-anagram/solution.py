"""
Time Complexity: O(n) - Where n is the length of the strings
Space Complexity: O(1) - At most 26 characters for lowercase English letters
"""
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        char_count = {}
        
        # Count characters in string s
        for char in s:
            char_count[char] = char_count.get(char, 0) + 1
        
        # Check characters in string t
        for char in t:
            if char not in char_count or char_count[char] == 0:
                return False
            char_count[char] -= 1
        
        return True

# Alternative approach using array (more efficient for lowercase letters)
class SolutionArray:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        char_count = [0] * 26
        
        for i in range(len(s)):
            char_count[ord(s[i]) - ord('a')] += 1
            char_count[ord(t[i]) - ord('a')] -= 1
        
        return all(count == 0 for count in char_count)

# Sorting approach
class SolutionSorting:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        return sorted(s) == sorted(t)

# Using Counter from collections
from collections import Counter

class SolutionCounter:
    def isAnagram(self, s: str, t: str) -> bool:
        return Counter(s) == Counter(t)
