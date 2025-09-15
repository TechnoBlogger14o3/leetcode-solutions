class Solution:
    def canBeTypedWords(self, text: str, brokenLetters: str) -> int:
        broken_set = set(brokenLetters)
        words = text.split()
        count = 0
        
        for word in words:
            if not any(char in broken_set for char in word):
                count += 1
        
        return count