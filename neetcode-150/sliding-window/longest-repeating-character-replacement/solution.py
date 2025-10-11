"""
Time Complexity: O(n) - Single pass through the string
Space Complexity: O(1) - At most 26 characters
"""
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left = 0
        max_length = 0
        max_count = 0
        char_count = {}
        
        for right in range(len(s)):
            right_char = s[right]
            char_count[right_char] = char_count.get(right_char, 0) + 1
            
            # Update max_count to track most frequent character
            max_count = max(max_count, char_count[right_char])
            
            # If window size - max_count > k, contract window
            if right - left + 1 - max_count > k:
                left_char = s[left]
                char_count[left_char] -= 1
                left += 1
            
            max_length = max(max_length, right - left + 1)
        
        return max_length

# Alternative approach using array for ASCII characters
class SolutionArray:
    def characterReplacement(self, s: str, k: int) -> int:
        char_count = [0] * 26
        left = 0
        max_count = 0
        max_length = 0
        
        for right in range(len(s)):
            right_char = s[right]
            char_count[ord(right_char) - ord('A')] += 1
            
            max_count = max(max_count, char_count[ord(right_char) - ord('A')])
            
            if right - left + 1 - max_count > k:
                left_char = s[left]
                char_count[ord(left_char) - ord('A')] -= 1
                left += 1
            
            max_length = max(max_length, right - left + 1)
        
        return max_length

# More concise version
class SolutionConcise:
    def characterReplacement(self, s: str, k: int) -> int:
        count = [0] * 26
        left = max_count = max_length = 0
        
        for right in range(len(s)):
            count[ord(s[right]) - ord('A')] += 1
            max_count = max(max_count, count[ord(s[right]) - ord('A')])
            
            if right - left + 1 - max_count > k:
                count[ord(s[left]) - ord('A')] -= 1
                left += 1
            
            max_length = max(max_length, right - left + 1)
        
        return max_length

# Using defaultdict for cleaner code
from collections import defaultdict

class SolutionDefaultDict:
    def characterReplacement(self, s: str, k: int) -> int:
        char_count = defaultdict(int)
        left = max_count = max_length = 0
        
        for right in range(len(s)):
            char_count[s[right]] += 1
            max_count = max(max_count, char_count[s[right]])
            
            if right - left + 1 - max_count > k:
                char_count[s[left]] -= 1
                left += 1
            
            max_length = max(max_length, right - left + 1)
        
        return max_length
