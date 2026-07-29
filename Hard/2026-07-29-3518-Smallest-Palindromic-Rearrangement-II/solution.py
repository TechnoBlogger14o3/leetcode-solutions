from collections import Counter
from itertools import permutations

class Solution:
    def kthPalindrome(self, s: str, k: int) -> str:
        half = []
        count = Counter(s)
        
        for char in sorted(count.keys()):
            half.append(char * (count[char] // 2))
        
        half_str = ''.join(half)
        palindromic_permutations = set()
        
        for perm in permutations(half_str):
            palindromic_permutations.add(''.join(perm) + ''.join(perm)[::-1])
        
        sorted_permutations = sorted(palindromic_permutations)
        
        if k > len(sorted_permutations):
            return ""
        
        return sorted_permutations[k - 1]