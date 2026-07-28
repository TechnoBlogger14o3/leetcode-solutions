class Solution:
    def smallestPalindromic(self, s: str) -> str:
        from collections import Counter
        
        count = Counter(s)
        half = []
        middle = ''
        
        for char in sorted(count.keys()):
            if count[char] % 2 == 1:
                if middle == '' or char < middle:
                    if middle:
                        half.append(middle)
                    middle = char
                else:
                    half.append(char)
            half.append(char * (count[char] // 2))
        
        half = ''.join(half)
        return half + middle + half[::-1]