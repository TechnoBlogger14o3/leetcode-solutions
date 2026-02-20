class Solution:
    def makeLargestSpecial(self, s: str) -> str:
        count = i = 0
        special_substrings = []
        
        for j in range(len(s)):
            count += 1 if s[j] == '1' else -1
            if count == 0:
                # Recursively solve the inner special string
                special_substrings.append('1' + self.makeLargestSpecial(s[i + 1:j]) + '0')
                i = j + 1
        
        # Sort the special substrings in reverse order to get the largest lexicographical order
        special_substrings.sort(reverse=True)
        
        return ''.join(special_substrings)