class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        result = []
        prev_word = ''
        
        for word in words:
            sorted_word = ''.join(sorted(word))
            if sorted_word != ''.join(sorted(prev_word)):
                result.append(word)
            prev_word = word
            
        return result