class Solution:
    def spellchecker(self, wordlist: List[str], queries: List[str]) -> List[str]:
        word_set = set(wordlist)
        lower_word_map = {}
        vowel_error_map = {}
        vowels = 'aeiou'
        
        for word in wordlist:
            lower_word = word.lower()
            if lower_word not in lower_word_map:
                lower_word_map[lower_word] = word
            vowel_key = ''.join(c if c not in vowels else '*' for c in lower_word)
            if vowel_key not in vowel_error_map:
                vowel_error_map[vowel_key] = word
        
        result = []
        
        for query in queries:
            if query in word_set:
                result.append(query)
            elif query.lower() in lower_word_map:
                result.append(lower_word_map[query.lower()])
            else:
                vowel_key = ''.join(c if c not in vowels else '*' for c in query.lower())
                result.append(vowel_error_map.get(vowel_key, ""))
        
        return result