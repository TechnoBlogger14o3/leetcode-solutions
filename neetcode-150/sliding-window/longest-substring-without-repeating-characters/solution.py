"""
Time Complexity: O(n) - Each character visited at most twice
Space Complexity: O(min(m,n)) - Where m is charset size
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        
        char_count = {}
        left = 0
        max_length = 0
        
        for right in range(len(s)):
            right_char = s[right]
            char_count[right_char] = char_count.get(right_char, 0) + 1
            
            # Contract window if duplicates found
            while char_count[right_char] > 1:
                left_char = s[left]
                char_count[left_char] -= 1
                left += 1
            
            max_length = max(max_length, right - left + 1)
        
        return max_length

# Alternative approach using Set
class SolutionSet:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        
        char_set = set()
        left = 0
        max_length = 0
        
        for right in range(len(s)):
            right_char = s[right]
            
            # Contract window if duplicate found
            while right_char in char_set:
                char_set.remove(s[left])
                left += 1
            
            char_set.add(right_char)
            max_length = max(max_length, right - left + 1)
        
        return max_length

# Optimized version with character position tracking
class SolutionOptimized:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_index = {}
        left = 0
        max_length = 0
        
        for right in range(len(s)):
            right_char = s[right]
            
            if right_char in char_index and char_index[right_char] >= left:
                left = char_index[right_char] + 1
            
            char_index[right_char] = right
            max_length = max(max_length, right - left + 1)
        
        return max_length

# More concise version
class SolutionConcise:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = set()
        left = max_length = 0
        
        for right in range(len(s)):
            while s[right] in seen:
                seen.remove(s[left])
                left += 1
            seen.add(s[right])
            max_length = max(max_length, right - left + 1)
        
        return max_length

# Using defaultdict for cleaner code
from collections import defaultdict

class SolutionDefaultDict:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_count = defaultdict(int)
        left = max_length = 0
        
        for right in range(len(s)):
            char_count[s[right]] += 1
            
            while char_count[s[right]] > 1:
                char_count[s[left]] -= 1
                left += 1
            
            max_length = max(max_length, right - left + 1)
        
        return max_length
