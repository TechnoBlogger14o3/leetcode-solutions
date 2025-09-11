class Solution:
    def sortVowels(self, s: str) -> str:
        vowels = 'aeiouAEIOU'
        vowel_positions = []
        vowel_chars = []

        for i, char in enumerate(s):
            if char in vowels:
                vowel_positions.append(i)
                vowel_chars.append(char)

        vowel_chars.sort()

        result = list(s)
        for pos, char in zip(vowel_positions, vowel_chars):
            result[pos] = char

        return ''.join(result)