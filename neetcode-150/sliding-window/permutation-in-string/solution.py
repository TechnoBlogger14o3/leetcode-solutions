"""
Time Complexity: O(n) - Where n is length of s2
Space Complexity: O(1) - At most 26 characters
"""
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        
        s1_count = [0] * 26
        s2_count = [0] * 26
        
        # Initialize frequency maps
        for i in range(len(s1)):
            s1_count[ord(s1[i]) - ord('a')] += 1
            s2_count[ord(s2[i]) - ord('a')] += 1
        
        # Check if initial window matches
        if s1_count == s2_count:
            return True
        
        # Slide window
        for i in range(len(s1), len(s2)):
            # Remove leftmost character
            s2_count[ord(s2[i - len(s1)]) - ord('a')] -= 1
            
            # Add rightmost character
            s2_count[ord(s2[i]) - ord('a')] += 1
            
            # Check if frequencies match
            if s1_count == s2_count:
                return True
        
        return False

# Alternative approach using Counter
from collections import Counter

class SolutionCounter:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        
        s1_count = Counter(s1)
        s2_count = Counter(s2[:len(s1)])
        
        if s1_count == s2_count:
            return True
        
        # Slide window
        for i in range(len(s1), len(s2)):
            # Remove leftmost character
            left_char = s2[i - len(s1)]
            s2_count[left_char] -= 1
            if s2_count[left_char] == 0:
                del s2_count[left_char]
            
            # Add rightmost character
            right_char = s2[i]
            s2_count[right_char] += 1
            
            if s1_count == s2_count:
                return True
        
        return False

# More concise version
class SolutionConcise:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        
        count = [0] * 26
        for c in s1:
            count[ord(c) - ord('a')] += 1
        
        left = 0
        for right in range(len(s2)):
            count[ord(s2[right]) - ord('a')] -= 1
            
            if right - left + 1 == len(s1):
                if all(x == 0 for x in count):
                    return True
                count[ord(s2[left]) - ord('a')] += 1
                left += 1
        
        return False

# Using defaultdict for cleaner code
from collections import defaultdict

class SolutionDefaultDict:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        
        s1_count = defaultdict(int)
        s2_count = defaultdict(int)
        
        # Initialize s1 frequency map
        for c in s1:
            s1_count[c] += 1
        
        # Initialize window
        for i in range(len(s1)):
            s2_count[s2[i]] += 1
        
        if s1_count == s2_count:
            return True
        
        # Slide window
        for i in range(len(s1), len(s2)):
            # Remove leftmost character
            left_char = s2[i - len(s1)]
            s2_count[left_char] -= 1
            if s2_count[left_char] == 0:
                del s2_count[left_char]
            
            # Add rightmost character
            right_char = s2[i]
            s2_count[right_char] += 1
            
            if s1_count == s2_count:
                return True
        
        return False
