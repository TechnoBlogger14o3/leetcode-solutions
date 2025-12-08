from typing import List

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        
        # Find the shortest string
        shortest = min(strs, key=len)
        
        # Check each character of the shortest string
        for i, char in enumerate(shortest):
            # Check if all strings have the same character at position i
            for string in strs:
                if string[i] != char:
                    return shortest[:i]
        
        return shortest

