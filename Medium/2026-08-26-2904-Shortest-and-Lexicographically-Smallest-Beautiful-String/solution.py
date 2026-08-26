class Solution:
    def smallestBeautifulString(self, s: str, k: int) -> str:
        n = len(s)
        min_length = float('inf')
        result = ""
        
        for i in range(n):
            count_ones = 0
            for j in range(i, n):
                if s[j] == '1':
                    count_ones += 1
                if count_ones > k:
                    break
                if count_ones == k:
                    substring = s[i:j + 1]
                    if len(substring) < min_length or (len(substring) == min_length and substring < result):
                        min_length = len(substring)
                        result = substring
        
        return result