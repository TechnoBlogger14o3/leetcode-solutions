class Solution:
    def weightedWordMapping(self, words: List[str], weights: List[int]) -> str:
        result = []
        for word in words:
            weight_sum = sum(weights[ord(char) - ord('a')] for char in word)
            mapped_char = chr(ord('z') - (weight_sum % 26))
            result.append(mapped_char)
        return ''.join(result)