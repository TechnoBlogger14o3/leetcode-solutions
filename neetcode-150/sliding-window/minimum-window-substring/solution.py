"""
Time Complexity: O(m + n) - Where m is length of s, n is length of t
Space Complexity: O(m + n) - For frequency maps
"""
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        
        t_count = {}
        for c in t:
            t_count[c] = t_count.get(c, 0) + 1
        
        left = 0
        min_start = 0
        min_len = float('inf')
        counter = len(t)
        
        for right in range(len(s)):
            right_char = s[right]
            
            if right_char in t_count:
                t_count[right_char] -= 1
                if t_count[right_char] >= 0:
                    counter -= 1
            
            while counter == 0:
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    min_start = left
                
                left_char = s[left]
                if left_char in t_count:
                    t_count[left_char] += 1
                    if t_count[left_char] > 0:
                        counter += 1
                left += 1
        
        return "" if min_len == float('inf') else s[min_start:min_start + min_len]

# Alternative approach using Counter
from collections import Counter

class SolutionCounter:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        
        t_count = Counter(t)
        left = 0
        min_start = 0
        min_len = float('inf')
        counter = len(t)
        
        for right in range(len(s)):
            right_char = s[right]
            
            if right_char in t_count:
                t_count[right_char] -= 1
                if t_count[right_char] >= 0:
                    counter -= 1
            
            while counter == 0:
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    min_start = left
                
                left_char = s[left]
                if left_char in t_count:
                    t_count[left_char] += 1
                    if t_count[left_char] > 0:
                        counter += 1
                left += 1
        
        return "" if min_len == float('inf') else s[min_start:min_start + min_len]

# More concise version
class SolutionConcise:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        
        t_count = Counter(t)
        left = min_start = 0
        min_len = float('inf')
        counter = len(t)
        
        for right in range(len(s)):
            if s[right] in t_count:
                t_count[s[right]] -= 1
                if t_count[s[right]] >= 0:
                    counter -= 1
            
            while counter == 0:
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    min_start = left
                
                if s[left] in t_count:
                    t_count[s[left]] += 1
                    if t_count[s[left]] > 0:
                        counter += 1
                left += 1
        
        return "" if min_len == float('inf') else s[min_start:min_start + min_len]

# Using defaultdict for cleaner code
from collections import defaultdict

class SolutionDefaultDict:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        
        t_count = defaultdict(int)
        for c in t:
            t_count[c] += 1
        
        left = min_start = 0
        min_len = float('inf')
        counter = len(t)
        
        for right in range(len(s)):
            if s[right] in t_count:
                t_count[s[right]] -= 1
                if t_count[s[right]] >= 0:
                    counter -= 1
            
            while counter == 0:
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    min_start = left
                
                if s[left] in t_count:
                    t_count[s[left]] += 1
                    if t_count[s[left]] > 0:
                        counter += 1
                left += 1
        
        return "" if min_len == float('inf') else s[min_start:min_start + min_len]
