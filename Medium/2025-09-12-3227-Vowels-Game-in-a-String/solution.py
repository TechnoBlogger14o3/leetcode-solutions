class Solution:
    def vowelGame(self, s: str) -> bool:
        vowels = set('aeiou')
        vowel_count = sum(1 for char in s if char in vowels)
        return vowel_count % 2 == 1