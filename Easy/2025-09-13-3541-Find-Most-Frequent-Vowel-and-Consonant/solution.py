from collections import Counter

class Solution:
    def maximumVowelsAndConsonants(self, s: str) -> int:
        vowels = set('aeiou')
        freq = Counter(s)
        
        max_vowel_freq = max((freq[char] for char in vowels), default=0)
        max_consonant_freq = max((freq[char] for char in freq if char not in vowels), default=0)
        
        return max_vowel_freq + max_consonant_freq