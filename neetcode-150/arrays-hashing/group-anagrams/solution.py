"""
Time Complexity: O(n * m log m) - Where n is number of strings, m is average length
Space Complexity: O(n * m) - For storing all strings
"""
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_groups = {}
        
        for str in strs:
            # Sort characters to create key
            key = ''.join(sorted(str))
            
            # Add to appropriate group
            if key not in anagram_groups:
                anagram_groups[key] = []
            anagram_groups[key].append(str)
        
        return list(anagram_groups.values())

# Alternative approach using character frequency count
class SolutionFrequency:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_groups = {}
        
        for str in strs:
            # Create frequency count key
            count = [0] * 26
            for char in str:
                count[ord(char) - ord('a')] += 1
            
            # Convert count array to tuple key
            key = tuple(count)
            
            # Add to appropriate group
            if key not in anagram_groups:
                anagram_groups[key] = []
            anagram_groups[key].append(str)
        
        return list(anagram_groups.values())

# Using defaultdict for cleaner code
from collections import defaultdict

class SolutionDefaultDict:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_groups = defaultdict(list)
        
        for str in strs:
            key = ''.join(sorted(str))
            anagram_groups[key].append(str)
        
        return list(anagram_groups.values())

# Using Counter for frequency approach
from collections import Counter

class SolutionCounter:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagram_groups = defaultdict(list)
        
        for str in strs:
            # Use Counter as key (convert to tuple for hashability)
            key = tuple(sorted(Counter(str).items()))
            anagram_groups[key].append(str)
        
        return list(anagram_groups.values())
