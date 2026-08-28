from collections import Counter

class Solution:
    def makeSmallestPalindrome(self, s: str) -> str:
        count = Counter(s)
        odd_count = sum(1 for v in count.values() if v % 2 != 0)
        
        if odd_count > 1:
            return ""
        
        half = []
        middle = ""
        
        for char in sorted(count.keys()):
            if count[char] % 2 == 1:
                middle = char
            half.append(char * (count[char] // 2))
        
        half_str = ''.join(half)
        palindrome = half_str + middle + half_str[::-1]
        return palindrome
    
    def next_palindrome(self, s: str) -> str:
        n = len(s)
        s_list = list(s)
        i = (n - 1) // 2
        
        while i >= 0:
            if s_list[i] < 'z':
                s_list[i] = chr(ord(s_list[i]) + 1)
                s_list[n - 1 - i] = s_list[i]
                return ''.join(s_list)
            s_list[i] = 'a'
            s_list[n - 1 - i] = 'a'
            i -= 1
        
        return ""
    
    def lexicographicallySmallestPalindromicPermutation(self, s: str, target: str) -> str:
        palindrome = self.makeSmallestPalindrome(s)
        if not palindrome or palindrome <= target:
            next_pal = self.next_palindrome(palindrome)
            if next_pal > target:
                return next_pal
            return ""
        return palindrome if palindrome > target else ""