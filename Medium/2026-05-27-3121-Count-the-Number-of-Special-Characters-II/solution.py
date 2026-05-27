class Solution:
    def countSpecialCharacters(self, word: str) -> int:
        special_count = 0
        seen_lower = set()
        seen_upper = set()
        
        for char in word:
            if char.islower():
                seen_lower.add(char)
            elif char.isupper():
                seen_upper.add(char.lower())
        
        for char in seen_upper:
            if char in seen_lower:
                first_upper_index = word.index(char.upper())
                first_lower_index = word.index(char.lower())
                if first_lower_index < first_upper_index:
                    special_count += 1
        
        return special_count