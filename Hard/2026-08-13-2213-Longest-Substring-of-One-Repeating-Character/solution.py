class Solution:
    def longestRepeating(self, s: str, queryCharacters: str, queryIndices: List[int]) -> List[int]:
        def longest_repeating_substring(s):
            max_length = 1
            current_length = 1
            
            for i in range(1, len(s)):
                if s[i] == s[i - 1]:
                    current_length += 1
                else:
                    max_length = max(max_length, current_length)
                    current_length = 1
            
            max_length = max(max_length, current_length)
            return max_length
        
        result = []
        s = list(s)
        
        for i in range(len(queryCharacters)):
            s[queryIndices[i]] = queryCharacters[i]
            result.append(longest_repeating_substring(s))
        
        return result